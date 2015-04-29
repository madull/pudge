package pudge;

public class Test {
	public static void main(String[] args) {
				String s="可租  5 辆 可还 23 辆";
				String replaceAll = s.trim().replaceAll("\\s+", "*").replaceAll("\\s*", "@").replaceAll(" +","").replaceAll("\\t", "_").replaceAll("\\n", "{").replaceAll(" ", "").replaceAll("\\r", "");
				String[] split = replaceAll.split(" ");
				String substring = s.substring(3,4);
				System.out.println(substring);
	}

}
