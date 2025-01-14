public class RealTaco implements TacoBox{
    @Override
    public int tacosRemaining() {
        return 0;
    }

    public String getTaco() {
        return "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⠀⣀⣤⣶⣶⢶⣄⡀⠀⢠⡶⠛⢶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⠟⠛⠋⠉⠉⣻⡏⠉⠉⣉⣿⠾⣿⣶⣟⠷⣶⣌⣻⡶⠶⣦⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡴⢿⣻⡵⠿⣧⠀⠀⣀⣴⡿⢶⣶⡾⠿⠟⢛⣋⣉⣉⣙⣛⣛⣿⣧⣤⣤⣿⠿⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⢾⣟⣛⣟⣛⠛⠲⢶⣿⡷⠿⣯⣭⠖⢋⣡⡤⠶⠚⠋⠉⣹⡿⠿⠿⠿⠿⢿⣤⠴⠶⠒⢿⡟⠒⢦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⡾⠟⠛⠛⠛⠛⠻⠿⠿⠶⠿⠿⢿⣿⣿⢿⣝⣓⣶⡶⠚⣿⣿⡷⠒⠒⠚⠛⠒⢿⡄⠀⣠⣬⣿⣤⣀⠘⠷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢠⣾⡿⠟⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢷⣦⣉⡛⠶⠾⠿⣿⣷⡀⠀⢀⣤⢶⣤⣿⣿⣿⣤⣈⣉⣙⡛⠿⠾⣷⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣴⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠿⠶⣶⣶⣮⡻⢾⡋⠁⠀⠀⠀⣹⡇⠀⠀⠙⢛⡿⣟⠳⠶⣿⣯⣻⣦⣀⡀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⣼⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣶⣝⢶⣄⣀⣴⣏⠀⢀⣠⣴⣯⡴⢿⣤⣀⣹⣇⠀⠀⠉⣿⠀⠀⠀⠀⠀\n" +
                "⠀⠀⣸⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣷⣍⠻⣭⣿⣶⡿⠛⢿⣅⡀⠀⢸⡏⠉⢿⣷⣦⣠⣿⣷⠀⠀⠀⠀\n" +
                "⠀⢠⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢷⣬⡙⢿⡷⣦⣀⠈⠙⢲⣾⣿⡆⠀⣷⣿⣠⣿⣿⢷⡆⠀⠀\n" +
                "⠀⣼⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠿⣮⡙⣦⡉⠳⣶⣿⣿⣠⣷⣾⠿⠿⠛⣿⣟⣿⣇⠀⠀\n" +
                "⢰⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣬⠻⣴⣿⣿⡿⣿⢿⣦⣤⣴⠶⢿⣿⣿⣿⡀⠀\n" +
                "⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣷⣍⣿⡼⠇⠿⣤⣹⣷⡾⣦⣼⣿⠃⣿⣧⠀\n" +
                "⠀⢹⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣷⡟⣶⣶⡟⠙⣧⣿⣿⠛⠿⣾⣿⣿⡀\n" +
                "⠀⠀⠙⠛⠶⠶⢶⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣮⢻⣧⣤⡿⢻⠉⢳⣤⣾⢿⣿⡇\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠛⠛⠶⣦⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⢿⣿⣠⡾⣿⣅⣘⣿⣧\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠻⠿⠶⢦⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣧⢙⣿⡿⠋⣰⠟⢿⣿⣿⣿\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠷⠶⠦⢤⣤⣄⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣷⢿⣧⣾⠟⣿⣻⣿⣿⡇\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠛⠛⠲⢶⣦⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣆⢻⣷⣤⣿⣿⣩⣿⡇\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠙⠛⠿⠶⠶⣦⣤⣄⣀⡀⠻⣦⣿⣏⣩⣿⣿⡟⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠛⠻⢿⣿⣿⣿⠟⠀⠀";
    }

    @Override
    public void eat() {

    }
}
