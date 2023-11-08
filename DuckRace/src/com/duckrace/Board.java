package com.duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 *
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 *
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

 public class Board {
    private final Map<Integer, String> studentIdMap = loadStudentIdMap();
    private final Map<Integer, DuckRacer> racerMap = new TreeMap<>();

    public int maxId() {
        // fix where this is. this is to not hard code the 19 in duck racer app
        return studentIdMap.size();
    }

    /*
     * Updates board (racerMap) by making a DuckRacer 'win'
     * this could mean fetching an existing DuckRacer from racerMap
     * or we might need to creat a new DuckRacker, if the id is not found
     * put it in the map, and make it win
     * Either way it needs to 'win'
     */

    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) { // if id is present, fetch DuckRacer next to it
            racer = racerMap.get(id);

        }
        else {
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);

        }
        racer.win(reward);
    }
     /*
      * TODO: render the data to show it like you see it every day
      *  "Duck Race Results"
      * =====================
      *
      * id    name   wins    rewards
      * --    ----    ----     -------
      * 1    Aaron     1       PRIZES
      * 3    Bullen    1       DEBIT_CARD
      * 3     CJ       2       DEBIT_CARD, DEBIT_CARD
      */
    // shows the board
    public void show() {
        Collection<DuckRacer> racers = racerMap.values();

        for (DuckRacer racer : racers) {
            //System.out.println(racer);
            System.out.printf("%s    %s     %s    %s\n",
                    racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
        }
    }

    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer, String> idMap = new HashMap<>();

        // for each line split it into 'tokens',i.e., "1,Aaron" is split into a '1' and 'Aaron'

        try {
            // read all lines from conf/student-ids.csv into a List<String>
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));

            for (String line : lines) {
                String[] tokens = line.split(","); // tokens[0] is '1' and tokens[1] is 'Aaron'

                idMap.put(Integer.valueOf(tokens[0]), tokens[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return idMap;
    }


}