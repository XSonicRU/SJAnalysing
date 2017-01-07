import java.util.Arrays;
import java.util.Vector;

public class Analysis {
    private static char[] data;
    private static int type;

    public Analysis(char[] sdata, int stype) { //type: 0 - letters, 1 - words, 2 - all chars(no whitespaces), 3 - digits,4 - all chars(with whitespaces)
        data = sdata;
        type = stype;
    }

    public char[] Start() {
        data = new String(data).trim().toCharArray();
        if (new String(data).equals("")) {
            return new char[]{' ', ' '};
        }
        if (type == 0) {
            Vector v = new Vector();
            for (char a : data) {
                if (!Character.isLetter(a)) {
                    continue;
                }
                if (v.contains(a)) {
                    int oldValue = (int) (v.get(v.indexOf(a) + 1));
                    v.remove(v.indexOf(a) + 1);
                    v.insertElementAt(oldValue + 1, v.indexOf(a) + 1);
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
        } else if (type == 1) {
            Vector v = new Vector();
            if (Arrays.binarySearch(data, ' ') == -1) {
                return new char[]{' ', ' '};
            }

        } else if (type == 2) {
            Vector v = new Vector();
            for (char a : data) {
                if (Character.isWhitespace(a)) {
                    continue;
                }
                if (v.contains(a)) {
                    int oldValue = (int) (v.get(v.indexOf(a) + 1));
                    v.remove(v.indexOf(a) + 1);
                    v.insertElementAt(oldValue + 1, v.indexOf(a) + 1);
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
        } else if (type == 3) {
            Vector v = new Vector();
            for (char a : data) {
                if (!Character.isDigit(a)) {
                    continue;
                }
                if (v.contains(a)) {
                    int oldValue = (int) (v.get(v.indexOf(a) + 1));
                    v.remove(v.indexOf(a) + 1);
                    v.insertElementAt(oldValue + 1, v.indexOf(a) + 1);
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
        } else { //type == 4
            Vector v = new Vector();
            for (char a : data) {
                if (v.contains(a)) {
                    int oldValue = (int) (v.get(v.indexOf(a) + 1));
                    v.remove(v.indexOf(a) + 1);
                    v.insertElementAt(oldValue + 1, v.indexOf(a) + 1);
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
        }
        return null; //useless string
    }
}
