package ru.shadar.game;

public final class War {
    private static War instance = null;
    private final RandomInput rnd = RandomInput.getInstance();
    private final String nl = System.lineSeparator();

    private Team blueTeam;
    private Team redTeam;
    private final Team[] teams = new Team[2];
    private final Race[] races = new Race[]{new Human(), new Elf(), new Orc(), new Undead()};

    protected static War getInstance() {
        if (instance == null) {
            instance = new War();
        }
        return instance;
    }

    private void createTeams() {
        Race blueTeamRace = races[rnd.nextInt(2)];
        Race redTeamRace = races[rnd.nextInt(2) + 2];
        System.out.println("Сгенерированы команды:" + nl);
        this.blueTeam = new Team(blueTeamRace);
        System.out.println("Синяя команда: " + nl + blueTeam);
        teams[0] = blueTeam;
        this.redTeam = new Team(redTeamRace);
        System.out.println("Красная команда: " + nl + redTeam);
        teams[1] = redTeam;
    }

    private boolean getWinner() {
        boolean run = true;
        if (!teams[0].isAlive() || !teams[1].isAlive()) {
            run = false;
        }
        return run;
    }

    private void priz() {
        StringBuilder stbl = new StringBuilder();

        for (int i = 0; i < 30; i++) {
            stbl.append("x ");
        }
        stbl.append(nl);
        for (int i = 0; i < 30; i++) {
            stbl.append(" x");
        }
        stbl.append(nl);
        for (int i = 0; i < 30; i++) {
            stbl.append("x ");
        }
        System.out.println(stbl.toString());
    }

    protected void start() {
        createTeams();
        boolean run = true;
        int count1 = 1;
        while (run) {
            teams[0].setTeamActive();
            teams[1].setTeamActive();
            System.out.println("Раунд " + count1 + "!");
            int teamMovieNumber = rnd.nextInt(2);
            int count2 = 1;
            if (teamMovieNumber == 0) {
                while ((teams[0].isTeamActive() || teams[1].isTeamActive()) && run) {
                    if (teams[0].isTeamActive()) {
                        System.out.println("Ход красные -> синие " + count1 + "." + count2);
                        teams[0].teamNewUnitMove(teams[1]);
                        teams[1].unitDie();
                        count2++;
                    }
                    if (teams[1].isTeamActive()) {
                        System.out.println("Ход синие -> красные " + count1 + "." + count2);
                        teams[1].teamNewUnitMove(teams[0]);
                        teams[0].unitDie();
                        count2++;
                    }
                    run = getWinner();
                    if (!run) {
                        break;
                    }
                }
            } else {
                while ((teams[0].isTeamActive() || teams[1].isTeamActive()) && run) {
                    if (teams[1].isTeamActive()) {
                        System.out.println("Ход синие -> красные " + count1 + "." + count2);
                        teams[1].teamNewUnitMove(teams[0]);
                        teams[0].unitDie();
                        count2++;
                    }
                    if (teams[0].isTeamActive()) {
                        System.out.println("Ход красные -> синие " + count1 + "." + count2);
                        teams[0].teamNewUnitMove(teams[1]);
                        teams[1].unitDie();
                        count2++;
                    }
                    run = getWinner();
                    if (!run) {
                        break;
                    }
                }
            }
            if (!run) {
                System.out.print("В " + count1 + " раунде есть ");
                if (teams[0].isAlive()) {
                    System.out.println("Победитель: " + nl + teams[0]);
                } else if (teams[1].isAlive()) {
                    System.out.println("Победитель: " + nl + teams[1]);
                } else {
                    System.out.println("Ничья!");
                }
                priz();
                break;
            }
            System.out.println(nl + "Прошел " + count1 + " раунд боя! Команды:" + nl);
            System.out.println("Синяя команда:" + nl + this.blueTeam);
            System.out.println("Красная команда:" + nl + this.redTeam);
            count1++;
        }
    }

    public static void main(String[] args) {
        War war = War.getInstance();
        war.start();
    }
}