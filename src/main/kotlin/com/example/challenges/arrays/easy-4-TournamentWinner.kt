package com.example.challenges.arrays

fun main() {
    val competitions = listOf(listOf("HTML", "C#"), listOf("C#", "Python"), listOf("Python", "HTML"))
    val results = listOf(0,0,1)
    println(tournamentWinner(competitions, results))
}

/*
3 points if it wins, 0 points if it loses
team 30 carachters - [home, awayTeam]
1 - home won
0 - awayTeam won
competitions = [
	["HTML, "C#],
	["C#, "Python],
	["Python, "HTML]
]
results = [0,0,1] --> away/away/home

1 loop to match first game and result
i will need a validation to verify if it was home or away
i will need a validation to calculate the points
*/
fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    var best = ""
    var teams = mutableMapOf(best to 0)

    for (i in 0 until competitions.size) {
        val (home, away) = competitions[i]
        var won = if (results[i] == 1) home else away

        if (!(won in teams)) teams[won] = 0

        teams[won] = teams[won]!! + 3
        println(teams)

        if (teams[won]!! > teams[best]!!) best = won
    }

    return best
}