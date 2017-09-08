public class GameOfSigns {

	public static void main(String[] args) {
		String[] m = { "LS", "LF"};
		System.out.println(gameOfSigns(m, "L"));
	}

	static boolean gameOfSigns(String[] m, String d) {

		int i = 0, j = 0;
		char[][] n = new char[m.length][];

		for (String s : m) {
			n[i++] = s.toCharArray();
		}

		i = 0;
		for (String s : m) {
			if ((j = s.indexOf('S')) >= 0)
				break;
			i++;
		}

		char c, f = d.charAt(0);

		
		
		n[i][j] = '-';
		while (i >= 0 && i < n.length && j >= 0 && j < n[i].length) {
			c = n[i][j];

			if(c=='F')
				return true;
			
			switch (f) {

			case 'U':
				if (c == 'R') {
					f = 'R';
					j++;
				}
				if (c == 'L') {
					f = 'L';
					j--;
				}
				if(c=='-'){
					i--;
				}
				break;

			case 'D':
				if (c == 'R') {
					f = 'L';
					j--;

				}
				if (c == 'L') {
						f = 'R';
						j++;
				}
				if(c=='-')
					i++;
				break;

			case 'L':
				if (c == 'R') {
					f = 'U';
					i--;

				}
				if (c == 'L') {
					f = 'D';
					i++;
				}
				if(c=='-')
					j--;
				break;
			case 'R':
				if (c == 'R') {

					f = 'D';
					i++;

				}
				if (c == 'L') {

					f = 'U';
					i--;

				}
				if(c=='-')
					j++;
				break;

			}


		}
		return false;

	}

}