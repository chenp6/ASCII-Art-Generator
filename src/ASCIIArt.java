import java.awt.image.BufferedImage;


public class ASCIIArt  {
	
	static String file = "";

	
	static int[][][] data;
	static int[][] grayData;
	static int height;
	static int width;
	static BufferedImage img = null;


	static void loadImg() {
		// 匯入img
		img = Util.loadImg(file);

		// 兩張圖寬高須相同
		height = img.getHeight();
		width = img.getWidth();

		// 建立data
		data = Util.makeRGBData(img);

		grayData = new int[height][width];
	}

	/**
	 * 取得圖片灰階資料
	 */
	static void convertToGrayData() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int[] d = data[y][x];
				grayData[y][x] = Util.covertToGray(d[0], d[1], d[2]);
			}
		}
	}

	
	/**
	 * 比較灰階後的資料,
	 * 若是超過limit,則輸出點,否則輸出空白
	 * @param limit 顯示點的最低灰階數值
	 */
	static void printASCIIArt(int limit) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int d = grayData[y][x];
				if (d > limit) {
					System.out.print(".");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		file = "file/Munich.png";	//填入檔名

		loadImg();
		convertToGrayData();
		
		printASCIIArt(60); //填入參數為顯示點的最低灰階數值		
	}
}
