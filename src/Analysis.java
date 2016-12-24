import java.util.Vector;

public class Analysis {
    private static char[] data;
    private static int type;

    public Analysis(char[] sdata, int stype) { //type: 0 - letters, 1 - words, 2 - all chars, 3 - digits
        data = sdata;
        type = stype;
    }

    public char[] Start() {
        int[] result;
        if (type == 0) {

        } else if (type == 1) {

        } else if (type == 2) {
            Vector v = new Vector();
            for (char a : data) {
                if (v.contains(a)) {
                    v.insertElementAt(((int) (v.get(v.indexOf(a) + 1)) + 1), v.indexOf(a) + 1);
                } else {
                    v.add(a);
                    v.add(1);
                }
            }
            int max = 0;
            for (int i = 1; i < v.size(); i = i + 2) {
                int buf = (int) v.get(i);
                if (buf > max) {
                    max = buf;
                }
            }

            return new char[]{(char) v.get(v.indexOf(max) - 1), (char) v.get(v.indexOf(1) - 1)}; //First - max, second - min
        } else { //type == 3

        }
        return null; //HOTFIX LOL
    }
}