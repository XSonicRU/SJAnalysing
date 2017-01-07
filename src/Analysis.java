import java.util.Arrays;
import java.util.Vector;

//TODO: Сделать первый тип до конца рабочим и исправить баг с тем что всегда минимально используемый объект это объект который есть используется один раз.
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
            int buf;
            int max = 0;
            for (int i = 1; i < v.size(); i = i + 2) {
                buf = (int) v.get(i);
                if (buf > max) {
                    max = buf;
                }
            }
            return new char[]{(char) v.get(v.indexOf(max) - 1), (char) v.get(v.indexOf(1) - 1)}; //First - max, second - min
        } else if (type == 1) {
            Vector v = new Vector();
            Vector words = new Vector();
            if (Arrays.binarySearch(data, ' ') == -1) {
                return new char[]{' ', ' '};
            }
            char cbuf;
            String sdata = new String(data);
            String buf = "";
            for (int i = 0; i < sdata.length(); i++) {
                cbuf = sdata.charAt(i);
                if (sdata.charAt(i) == ' ') {
                    words.add(buf);
                    buf = "";
                } else {
                    buf = buf + cbuf;
                }
            }
            Object obuf;
            for (int i = 0; i < words.size(); i++) {
                obuf = words.get(i);
                if (v.contains(obuf)) {
                    int ind = v.indexOf(obuf) + 1;
                    v.remove(ind);
                    v.insertElementAt(((int) v.get(ind)) + 1, ind);
                } else {
                    v.add(obuf);
                    v.add(1);
                }
            }
            int ibuf;
            int max = 0;
            for (int i = 1; i < v.size(); i = i + 2) {
                ibuf = (int) v.get(i);
                if (ibuf > max) {
                    max = ibuf;
                }
            }
            return null; //F*** IT
        } else if (type == 2) {
            Vector v = new Vector();
            for (char a : data) {
                if (Character.isWhitespace(a)) {
                    continue;
                }
                if (v.contains(a)) {
                    int ind = v.indexOf(a) + 1;
                    v.remove(ind);
                    v.insertElementAt(((int) (v.get(ind))) + 1, ind);
                } else {
                    v.add(a);
                    v.add(1);
                }
            }
            int buf;
            int max = 0;
            for (int i = 1; i < v.size(); i = i + 2) {
                buf = (int) v.get(i);
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
                    int ind = v.indexOf(a) + 1;
                    v.remove(ind);
                    v.insertElementAt(((int) (v.get(ind))) + 1, ind);
                } else {
                    v.add(a);
                    v.add(1);
                }
            }
            int buf;
            int max = 0;
            for (int i = 1; i < v.size(); i = i + 2) {
                buf = (int) v.get(i);
                if (buf > max) {
                    max = buf;
                }
            }
            return new char[]{(char) v.get(v.indexOf(max) - 1), (char) v.get(v.indexOf(1) - 1)}; //First - max, second - min
        } else { //type == 4
            Vector v = new Vector();
            for (char a : data) {
                if (v.contains(a)) {
                    int ind = v.indexOf(a) + 1;
                    v.remove(ind);
                    v.insertElementAt(((int) (v.get(ind))) + 1, ind);
                } else {
                    v.add(a);
                    v.add(1);
                }
            }
            int buf;
            int max = 0;
            for (int i = 1; i < v.size(); i = i + 2) {
                buf = (int) v.get(i);
                if (buf > max) {
                    max = buf;
                }
            }

            return new char[]{(char) v.get(v.indexOf(max) - 1), (char) v.get(v.indexOf(1) - 1)}; //First - max, second - min
        }
    }
}
