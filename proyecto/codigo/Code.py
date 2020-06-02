import os
import csv

def create_df(file):

    with open(file, encoding = 'utf-8') as csv_file:
        lines = csv.reader(csv_file, delimiter = ';')
        df = []
        length = 0
        for line in lines:
            if line[0] == "estu_consecutivo.1":
                labels = line
                continue
            df.append(line)
            length += 1

    return df, length, labels

def labelling(df):

    counts = {}

    for line in df[1:]:
        target = line[-1]
        if target not in counts:
            counts[target] = 0
        counts[target] += 1

    return counts

def is_numeric(value):

    return isinstance(value, int) or isinstance(value, float)

class Question_format:

    def __init__(self, column, value):

        """ Store the column and value used to partition the data."""
        self.column = column
        self.value = value

    def match(self,row):

        val=row[self.column]

        if isinstance(val, (str,float)):
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
        vals = set([line[col] for line in df])
        for val in vals:
            question = Question_format(col, val)
            true_rows, false_rows = partition(df, question)
            if len(true_rows) == 0 or len(false_rows) == 0:
                continue
            gain = information_gain(true_rows, false_rows, uncertainty)

            if gain >= maximum_gain:
                maximum_gain, best_question, col_name = gain, question, labels[col]

    return maximum_gain, best_question, col_name

def create_question(question, column):

    arr = str(question).split()
    return arr[0] + " " + column + " " + arr[2] + " " + arr[3]

class Leaf:

    def __init__(self, df):

        self.prediction = prediction(df)

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

def prediction(df):

    counts = labelling(df)

    success = 0
    fail = 0

    for x, y in counts.items():
        if x == 1:
            success = y
        else:
            fail = y

    total = success + fail
    prediction = round((success / total), 2)

    return prediction

'''
class Tree:

    def __init__(self, df, labels, depth):

'''

'''
def treePNG(tree, labels):

    dot_data = StringIO()
    export_graphviz(tree, out_file=dot_data, filled=True, rounded=True, special_characters=True, feature_names = labels)
    graph = pydotplus.graph_from_dot_data(dot_data.getvalue())
    graph.write_png('results.png')
    Image(graph.create_png())
'''

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

'''
def classify(id, root, students):
    node = root
    data = students[id].data
    while True:
        try:
            if data[node.column] >= node.divider:
                if not node.right.leaf_node:
                    node = node.right
                else:
                    return node.right.probability
            else:
                if not node.left.leaf_node:
                    node = node.left
                else:
                    return node.left.probability
        except:
            try:
                if data[node.column] == node.divider:
                    if not node.right.leaf_node:
                        node = node.right
                    else:
                        return node.right.probability
                else:
                    if not node.left.leaf_node:
                        node = node.left
                    else:
                        return node.left.probability
            except:
                if data[node.column]:
                    if not node.right.leaf_node:
                        node = node.right
                    else:
                        return node.right.probability
                else:
                    if not node.left.leaf_node:
                        node = node.left
                    else:
                        return node.left.probability
'''

if __name__ == "__main__":
    train_file = os.path.expanduser('~\Documents\EAFIT\Segundo Semestre\Datos y Algoritmos 1\Proyecto\lite.csv')
    test_file = os.path.expanduser('~\Documents\EAFIT\Segundo Semestre\Datos y Algoritmos 1\Proyecto\lite.csv')
    df, length, labels = create_df(train_file)
    df2, length2, labels2 = create_df(test_file)
    tree = build_tree(df, 6)
    correct = 0
    total = 0
    for line in df2:
        prediction = classify(line, tree)
        actual = int(line[-1])
        if prediction == actual:
            correct += 1
        total += 1
    accuracy = correct / total * 100
    print(str(accuracy) + "%")
