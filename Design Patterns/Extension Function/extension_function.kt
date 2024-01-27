fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""

    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()

    println("Slug gerado para o livro:")
    println("${slugTitulo}_${slugAutor}")
}

fun String.generateSlug(): String {
    // Remove espaços e caracteres especiais, substituindo-os por traços
    val slug = this.toLowerCase()
        .replace(Regex("[^a-zA-Z0-9]"), "-")
        .replace(Regex("-+"), "-")

    return slug
}