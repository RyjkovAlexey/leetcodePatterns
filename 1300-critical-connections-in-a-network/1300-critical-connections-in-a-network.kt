import java.lang.Integer.min

class Solution {
    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        val graph = mutableListOf<MutableList<Int>>()

        for (i in 0 until n) {
            graph.add(mutableListOf())
        }

        for (list in connections) {
            graph[list[0]].add(list[1])
            graph[list[1]].add(list[0])
        }

        val visited = Array(n) { false }
        val discovery = Array(n) { -1 }
        val lowStep = Array(n) { -1 }
        val result = mutableListOf<List<Int>>()

        fun deepDive(server: Int, parent: Int, step: Int) {
            var step = step
            visited[server] = true
            discovery[server] = step
            lowStep[server] = step

            for (neighbor in graph[server]) {
                if (neighbor == parent) continue

                if (!visited[neighbor]) {
                    step++
                    deepDive(neighbor, server, step)
                    lowStep[server] = lowStep[server].coerceAtMost(lowStep[neighbor])

                    if (discovery[server] < lowStep[neighbor]) {
                        result.add(listOf(server, neighbor))
                    }
                } else {
                    lowStep[server] = lowStep[server].coerceAtMost(discovery[neighbor])
                }
            }
        }

        deepDive(0, -1, 0)

        return result;
}
}