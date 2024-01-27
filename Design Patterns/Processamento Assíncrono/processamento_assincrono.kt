fun main() {
    val urls = mutableListOf<String>()

    while (true) {
        val input = readLine() ?: break
        if (input.isBlank()) break
        urls.add(input)
    }

    println("Iniciando downloads...")

    // Cria uma lista de Pair (índice, tamanho)
    val results = mutableListOf<Pair<Int, Int>>()

    // Inicia cada Thread para começar o processo de 'download' paralelamente
    val threads = urls.mapIndexed { index, url ->
        Thread {
            val length = openLink(url)
            synchronized(results) {
                results.add(Pair(index, length))
            }
        }
    }

    // Inicia todas as Threads
    threads.forEach(Thread::start)

    // Aguarda até que todas as Threads terminem suas respectivas execuções
    threads.forEach(Thread::join)

    // Ordena os resultados por índice para imprimir na ordem correta
    results.sortedBy { it.first }.forEachIndexed { idx, result ->
        println("Arq${idx + 1}: ${result.second}")
    }
    println("Tempo total: ${urls.size}")
}

// Simula a abertura de uma URL, retornando seu tamanho.
fun openLink(url: String): Int {
    // Simulação simplificada - você pode realizar operações reais de download aqui
    // neste caso, estamos retornando o comprimento da URL
    return url.length
}
