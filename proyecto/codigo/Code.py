import os
import csv
import time
import psutil
from sklearn.metrics import confusion_matrix

def create_df(file):

    cont = 0
    with open(file, encoding = 'utf-8') as csv_file:
        lines = csv.reader(csv_file, delimiter = ';')
        df = []
        length = 0
        for line in lines:
            if line[0] == "estu_consecutivo.1" or line[0] == "":
                labels = line
                continue
            df.append(line)
            length += 1
            cont += 1

    return df, length, labels

def labelling(df):

    counts = {}

    for line in df[:]:
        target = line[-1]
        if target not in counts:
            counts[target] = 0
        counts[target] += 1

    return counts

def is_numeric(value):

    return isinstance(value, int) or isinstance(value, float)

def is_number(value):
    """ Determines wether a given value is numeric.
    Input : a value
    """
    try:
        float(value)
        return True
    except ValueError:
        pass
    try:
        import unicodedata
        unicodedata.numeric(value)
        return True
    except (TypeError, ValueError):
        pass

    return False

def bestValue (df, columnNum):
    """
    Counts how many success cases there are according to a given value a column
    can take, stores it into a dictionary, and returns the value that has the most success cases.
    Input : the dataset organized into a matrix and the column number.
    Output : best value for the column imput
    """
    dictionary = {}
    for line in df:
        data = line[columnNum]
        if data not in dictionary:
            dictionary [data] = 0
        dictionary [data] += int(line[-1])
    bestValue = None
    bestSuccess = 0
    for data in dictionary:
        if (dictionary[data] >= bestSuccess):
            bestSuccess = dictionary[data]
            bestValue = data
    return bestValue

class Question_format:

    def __init__(self, column, value):

        """ Store the column and value used to partition the data."""
        self.column = column
        self.value = value

    def match(self,row):

        val=row[self.column]

        if isinstance(val, (str,float)) or is_number(val):
            return val == self.value
        else:
            return val >= self.value

    def __repr__(self):

        """ To string method. """
        condition = "=="

        if is_numeric(self.value):
            condition = ">="

        return "Is {} {} {}?".format(self.column, condition, self.value)

def partition(df, question):

    true_values, false_values = [], []

    for line in df:
        if question.match(line):
            true_values.append(line)
        else:
            false_values.append(line)

    return true_values, false_values

def gini(df):

    counts = labelling(df)
    impurity = 1

    for label in counts:
        prob = counts[label] / float(len(df))
        impurity -= prob**2

    return impurity

def information_gain(left, right, uncert):

    info = float(len(left)) / (len(left) + len(right))
    return uncert - info * gini(left) - (1 - info) * gini(right)

def best_option(df):

    maximum_gain = 0
    best_question = None
    uncertainty = gini(df)
    n_columns = len(df[0]) - 1
    global col_name

    for col in range(n_columns):
        val = bestValue(df, col)
        question = Question_format(col, val)
        true_rows, false_rows = partition(df, question)
        gain = information_gain(true_rows, false_rows, uncertainty)

        if gain >= maximum_gain:
            maximum_gain, best_question, col_name = gain, question, labels[col]

    return maximum_gain, best_question, col_name

def create_question(question, column):

    arr = str(question).split()
    return arr[0] + " " + column + " " + arr[2] + " " + arr[3]

class Leaf:

    def __init__(self, df):

        self.prediction = predict(df)

class Decision_Node:

    def __init__(self, question, true, false):

        self.question = question
        self.true = true
        self.false = false

def build_tree(df, depth):

    gain, question, column = best_option(df)

    if gain == 0 or depth == 0:
        return Leaf(df)

    true_rows, false_rows = partition(df, question)
    true_side = build_tree(true_rows, depth - 1)
    false_side = build_tree(false_rows, depth - 1)

    best_question = create_question(question, column)
    return Decision_Node(question, true_side, false_side)

def print_tree(node, spacing = ""):

    if isinstance(node, Leaf):
        print(spacing + "Predict", node.prediction)
        return

    print(spacing + str(node.question))

    print(spacing + "--> True")
    print_tree(node.true, spacing + " ")

    print(spacing + "--> False")
    print_tree(node.false, spacing + " ")

def predict(df):
    counts = labelling(df)

    success = 0
    fail = 1

    if '1' in counts:
        success = counts['1']

    if '0' in counts:
        fail = counts['0']

    total = success + fail
    predict = round((success / total), 2)

    return predict

def classify(line, node):

    if isinstance(node, Leaf):
        if float(node.prediction) >= 0.5:
            return 1
        else:
            return 0

    if node.question.match(line):
        return classify(line, node.true)
    else:
        return classify(line, node.false)

if __name__ == "__main__":
    #t1 = time.time()
    train_file = os.path.expanduser('5_train_balanced_57765.csv')
    test_file = os.path.expanduser('5_test_balanced_19255.csv')
    df, length, labels = create_df(train_file)
    df2, length2, labels2 = create_df(test_file)
    #process = psutil.Process(os.getpid())
    #print("Memory consumed in megabytes:", round((process.memory_info()[0] / 1000000), 2))
    #t2 = time.time()
    #time = (t2 - t1) * 1000
    #print("Time in ms:", round(time, 2))
    tree = build_tree(df, 9)
    correct = 0
    total = 0
    success = []
    prob = []
    for line in df2:
        prediction = classify(line, tree)
        actual = int(line[-1])
        if prediction == actual:
            correct += 1
        total += 1
        success.append(prediction)
        prob.append(actual)
    accuracy = correct / total * 100
    print(str(accuracy) + "%")
    print(confusion_matrix(prob, success))
