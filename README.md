# Algs-Shortest-Path-Dictionary

The purpose of this is to implement an application that given a starting word and ending word will compute the shortest path in a weighted graph from starting word to ending word subject to the following constraints: The words along the path must be contained in the English dictionary and every word differs from one that follows by one letter and they are all of the same length. If a path doesn't exist then the algorithm should return "no path exists".
Example: 
starting word:  game
ending word:  kite
Here is an example of a path that is not guaranteed to be the shortest: game > gate > gite > kite. Highlighted letters are the ones that change from word to the next.
The Algorithm:
Constructs a graph of all the words in the dictionary. Two words are connected by an edge if they are the same length and differ by one letter. The weight of the edge is the difference between the two letters ASCII values (absolute value). Implemented as an adjacency list. 
Runs Dijkstra's algorithm from the starting word until it finds the ending word or the search terminates because no more words are left to explore. If the search terminates because there are no more nodes reachable from the starting word, then there is no path.
The user is able to repeatedly input two words: start and end and get the path from start to end as well as the length of the path. Note that you shouldn't have to rebuild the graph for each query. If the two words are not the same length then the user is notified and prompted for two new words.
