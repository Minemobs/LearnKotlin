fun main(args: Array<String>){
    println("What's your name ?")
    val name: String = readLine().toString()
    println(String.format("Hello %s !", name))
}