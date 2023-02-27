package cli

abstract class PageCrudCli extends PageCli {
    abstract void add()

    abstract void remove()

    abstract void update()

    abstract void show()

    abstract void showAll()

    void quit() {
        Scanner sc = new Scanner(System.in)
        String q
        while (q != "q") {
            printf "quit page? [q] "; q = sc.nextLine()
        }
    }
}