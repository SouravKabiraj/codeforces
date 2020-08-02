import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class YetAnotherWalkingRobot {
    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // handleMultipleTestCases(br);
    	int T = Integer.parseInt(br.readLine());
	for(int tc=0;tc<T;tc++) {
		br.readLine();
		char[] path = readChars(br);
		int[] result = getRemovedPosition(path);
		if(result[1]==path.length) {
			System.out.println(-1);
		}else {
			System.out.println((result[0]+2)+" "+(result[1]+1));
		}
	}
    }

    private static int[] getRemovedPosition(char[] path) {
    	HashMap<Cell,ArrayList<Integer>> cellIndex = new HashMap<>();
	int x= 0;
	int y= 0;
	ArrayList<Integer> l = new ArrayList<>();
	l.add(-1);
	cellIndex.put(new Cell(0,0),l);
	
	for(int i=0; i<path.length; i++) {
		if(path[i]=='U') {
			y=y+1;
		}else if(path[i]=='D'){
			y=y-1;
		}else if(path[i]=='L'){
			x=x-1;
		}else {
			x=x+1;
		}
		
		ArrayList<Integer> list;
		if(cellIndex.containsKey(new Cell(x,y))){
			list = cellIndex.get(new Cell(x,y));
			list.add(i);
		}else {
			list = new ArrayList<>();
			list.add(i);
		}
		cellIndex.put(new Cell(x,y),list);
	}

	var ref = new Object(){
		int start = -1; 
		int end = path.length;
	};

	cellIndex.forEach((k,v)->{
		if(cellIndex.get(k).size()>1){
			for(int i=0; i<cellIndex.get(k).size()-1; i++) {
				if(cellIndex.get(k).get(i+1)-cellIndex.get(k).get(i) < ref.end-ref.start) {
					ref.start = cellIndex.get(k).get(i);
					ref.end = cellIndex.get(k).get(i+1);
				}
			}
		}
	});

	return new int[]{ref.start,ref.end};
    }

    private static void handleMultipleTestCases(BufferedReader br) throws Exception {
        int T = readInt(br);
        for (int tc = 0; tc < T; tc++) {
            handleTestCase(br);
        }
    }

    private static void handleTestCase(BufferedReader br) throws Exception {
        print(readArrInt(br));
        System.out.println(readList(br));
        int[][] ar = new int[][]{{1, 2}, {1, 2}};
        print(ar);
    }

    private static int readInt(BufferedReader br) throws Exception {
        return Integer.parseInt(br.readLine());
    }

    private static char[] readChars(BufferedReader br) throws Exception {
    	String line = br.readLine();
	// System.out.println(line);
        char[] arr = new char[line.length()];
        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i);
        }
        return arr;
    }

    private static int[] readArrInt(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        return arr;
    }

    private static List<Integer> readList(BufferedReader br) throws Exception {
        String[] line = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
        return arr;
    }

    private static void print(int[][] mat) {
        System.out.println("----------------------------------------");
        for (int i = 0; i < mat.length; i++) {
            System.out.print("{");
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("}");
        }
        System.out.println("----------------------------------------");
    }

    private static void print(int[] mat) {
        System.out.print("{");
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println("}");
    }
}

class Cell {
	public int x;
	public int y;

	Cell(int x, int y) {
		this.x= x;
		this.y=y;
	}

	public String toString(){
		return "{ x:"+x+" y:"+y+"} ";
	}

	@Override
    	public boolean equals(Object o) {
        	if (this == o) return true;
        	if (o == null || getClass() != o.getClass()) return false;
        	Cell cell = (Cell) o;
        	return x == cell.x &&
                	y == cell.y;
    	}

    	@Override
    	public int hashCode() {
        	return Objects.hash(x, y);
    	}
}
