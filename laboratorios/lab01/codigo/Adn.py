def adn(chain1, chain2, x, y):
    if x==0 or y==0:
        return 0
    if chain1[x-1]==chain2[y-1]:
        return 1 + adn(chain1, chain2, x-1, y-1)
    return max(adn(chain1, chain2, x-1, y), adn(chain1, chain2, x, y-1))
    
print(adn("ABCDGH", "AEDFHR", 6, 6))