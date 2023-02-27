package cli

abstract class PageCli {
    String title
    String divider
    String showSession
    HashMap<Integer, List> options

//    PageCLI(String title, String divider, String showSession, HashMap<Integer, List> options) {
//        this.title = title
//        this.divider = divider
//        this.showSession = showSession
//        this.options = options
//    }

    void init() {
        structure()
        Integer option = chooseOption()
        options[option][1]()
    }

    void structure() {
        printf "\n" * 100
        println divider
        println title
        println divider
        println showSession
        println divider
        println "→ Choose an option:"
        options.each { it -> println "${it.key} - ${it.value[0]}" }
        println divider
        printf "→ Your choice: "
    }

    int chooseOption() {
        Scanner sc = new Scanner(System.in)
        return sc.nextInt()
    }


}