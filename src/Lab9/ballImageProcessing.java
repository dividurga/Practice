package homework8;

import external.Picture;
import java.awt.Color;
import java.util.ArrayList;

public class d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Picture img = new Picture("REDACT/Poster 5.jpg");
		
		distanceCluster(img);
		img.show();

	}

	public static Picture showRed(Picture sourceImg) {
		int red = 0;
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				red = sourceImg.get(i, j).getRed();
				newPicture.set(i, j, new Color(red, 0, 0));
			}

		}
		return newPicture;
	}
	
	public void resizeImage (Picture sourceImg, int scaleWidth, int scaleHeight) {
		int width = sourceImg.width();
		int height = sourceImg.height();
		Picture resizedPic = new Picture (width*scaleWidth,height*scaleHeight);
		int c=0;
		
		for(int i=0; i <width; i++) {
			for (int j =0; j <height ; j++) {
				for(int x=0; x <scaleWidth; x++) {
					for(int y=0; y<scaleHeight; y++) {
				resizedPic.set(i*scaleWidth + x,j*scaleHeight + y, sourceImg.get(i, j));
				}
			}
		}
		//increase no of pixels 
		
	}
	}
	/*

	public static Picture showRedBall(Picture sourceImg) {
		int red = 0;
		int blue = 0;
		int green = 0;
		int redpixel = 0;
		int countball = 0;
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				red = sourceImg.get(i, j).getRed() + 1;
				blue = sourceImg.get(i, j).getBlue() + 1;
				green = sourceImg.get(i, j).getGreen() + 1;
				if (80 < red && red / blue > 1.5 && red / green > 1.5) {
					newPicture.set(i, j, new Color(red, 0, 0));
				} else {
					newPicture.set(i, j, new Color(255, 255, 255));
				}
			}
		}
		// recursive algorithm to find clusters
		// check a red dot. check top bottom left right for red dot add to red pixel
		// base case if not red dot then return

		System.out.println(countball);

		return newPicture;

	}
	*/
	/*
	 * public static void recursiveCluster (int a, int b) { Picture pic = new
	 * Picture("/Users/divija/Downloads/Poster 5.jpg"); Picture sourceImg=
	 * showRedBall(pic); ArrayList<int[]> arrlist = new ArrayList<int[]>(); for (int
	 * i=0; i <sourceImg.width(); i++) { for (int j=0; j<sourceImg.width(); j++) {
	 * int[] arr= new int [] {i,j}; arrlist.add(arr);
	 * 
	 * } } int redpixel = 0;
	 * 
	 * for (int i = arrlist.size() - 1; i >= 0; i--) { int[] elem = arrlist.get(i);
	 * int red = sourceImg.get(elem[0], elem[1]).getRed(); int blue =
	 * sourceImg.get(elem[0], elem[1]).getBlue(); int green = sourceImg.get(elem[0],
	 * elem[1]).getGreen();
	 * 
	 * if (red > 50 && blue < 100 && green < 100) { recursiveCluster(elem[0] + 1,
	 * elem[1]); recursiveCluster(elem[0] - 1, elem[1]); recursiveCluster(elem[0],
	 * elem[1] + 1); recursiveCluster(elem[0], elem[1] - 1); arrlist.remove(i);
	 * redpixel += 1; } }
	 * 
	 * System.out.println("Redpixel: " + redpixel);
	 * 
	 * }
	 * 
	 */
/*
	public static int recursiveCluster(int i, int j, int redpixel, ArrayList<int[]> arrlistvisited) {
		Picture pic = new Picture("/Users/divija/Downloads/Poster 5.jpg");
		Picture sourceImg = showRedBall(pic);
		if (i < 0 || j < 0 || i >= pic.width() || j >= pic.height() || arrlistvisited.contains(new int[] { i, j })) {
			return redpixel;
		}

		else {
			arrlistvisited.add(new int[] { i, j });
			int red = sourceImg.get(i, j).getRed();
			int blue = sourceImg.get(i, j).getBlue();
			int green = sourceImg.get(i, j).getGreen();
			if (50 < red && blue < 100 && green < 100) {
				redpixel += 1;
				recursiveCluster(i + 1, j, redpixel, arrlistvisited);
				recursiveCluster(i - 1, j, redpixel, arrlistvisited);
				recursiveCluster(i, j + 1, redpixel, arrlistvisited);
				recursiveCluster(i, j - 1, redpixel, arrlistvisited);
				return redpixel;
			}

			else {
				return redpixel;
			}

		}

	}
	*/

	public static void distanceCluster(Picture img) {
		int redball = 0;
		int greenball = 0;
		int blueball = 0;
		int threshold=100;
		int[] pixelred = new int[2];
		int[] newpixelred = new int[2];
		int[] pixelgreen = new int[2];
		int[] newpixelgreen = new int[2];
		int[] pixelblue = new int[2];
		int[] newpixelblue = new int[2];
		
		
		for (int i = 0; i < img.width(); i++) {
			for (int j = 0; j < img.height(); j++) {
				int red = img.get(i, j).getRed() + 1;
				int blue = img.get(i, j).getBlue() + 1;
				int green = img.get(i, j).getGreen() + 1;

				
				if (50 < red && red / blue > 1 && red / green > 1) {
					if (redball == 0) {
						pixelred[0] = i;
						pixelred[1] = j;
						redball++;
					}
					newpixelred[0] = i;
					newpixelred[1] = j;
					// System.out.println(i+" "+j);
					double distance = Math.sqrt(
							Math.pow(newpixelred[0] - pixelred[0], 2) + Math.pow(newpixelred[1] - pixelred[1], 2));

					pixelred[0] = i;
					pixelred[1] = j;
					if (distance > threshold) {
						redball++;
					}

				}
				
				if (green > 50 && green / red > 1) {
					if (greenball == 0) {
						pixelgreen[0] = i;
						pixelgreen[1] = j;
						greenball++;
					}
					newpixelgreen[0] = i;
					newpixelgreen[1] = j;
					// System.out.println(i+" "+j);
					double distance = Math
							.sqrt(Math.pow(newpixelgreen[0] - pixelgreen[0], 2) + Math.pow(newpixelgreen[1] - pixelgreen[1], 2));

					pixelblue[0] = i;
					pixelblue[1] = j;
					if (distance > threshold) {
						greenball++;
					}
					}
					
				
				if (blue > 50 && blue / red > 1) {
					if (blueball == 0) {
						pixelblue[0] = i;
						pixelblue[1] = j;
						blueball++;
					}
					newpixelblue[0] = i;
					newpixelblue[1] = j;
					// System.out.println(i+" "+j);
					double distance = Math
							.sqrt(Math.pow(newpixelblue[0] - pixelblue[0], 2) + Math.pow(newpixelblue[1] - pixelblue[1], 2));

					pixelblue[0] = i;
					pixelblue[1] = j;
					if (distance > threshold) {
						blueball++;
					}
					}
				
				}}
		
		System.out.println("Redballs:" +redball);

		System.out.println("Greenballs:" + greenball);
		System.out.println("Blueballs:"+ blueball);
				/*
				
			
			}
		
			
			}
			*/
	
		}



	/*
	 * public static int recursiveCluster(int x, int y, int redpixel) { Picture pic
/*
	 * = new Picture("/Users/divija/Downloads/Poster 5.jpg"); Picture sourceImg =
	 * showRedBall(pic); boolean[][] visited = new
	 * boolean[pic.width()][pic.height()];
	 * 
	 * return recursiveClusterHelper(x, y, redpixel, visited, sourceImg); }
	 * 
	 * private static int recursiveClusterHelper(int x, int y, int redpixel,
	 * boolean[][] visited, Picture sourceImg) { if (x < 0 || y < 0 || x >=
	 * visited.length || y >= visited[0].length || visited[x][y]) { return redpixel;
	 * }
	 * 
	 * visited[x][y] = true;
	 * 
	 * int red = sourceImg.get(x, y).getRed(); int blue = sourceImg.get(x,
	 * y).getBlue(); int green = sourceImg.get(x, y).getGreen();
	 * 
	 * if (red > 50 && blue < 100 && green < 100) { redpixel += 1;
	 * 
	 * redpixel = recursiveClusterHelper(x + 1, y, redpixel, visited, sourceImg);
	 * redpixel = recursiveClusterHelper(x - 1, y, redpixel, visited, sourceImg);
	 * redpixel = recursiveClusterHelper(x, y + 1, redpixel, visited, sourceImg);
	 * redpixel = recursiveClusterHelper(x, y - 1, redpixel, visited, sourceImg); }
	 * 
	 * return redpixel; }
	 */
	/*
	public static int[] numBall(Picture sourceImg) {
		int red = 0;
		int blue = 0;
		int green = 0;
		int bluepixel = 0;
		int greenpixel = 0;
		int redpixel = 0;
		int blueball = 0;
		int redball = 0;
		int greenball = 0;
		int[] countball = new int[3];
		int neg = 100;
		int thresholdgreen = 50;
		int thresholdred=10;
		int thresholdblue=10;

		for (int k = 0; k < sourceImg.width() - neg; k += neg) {
			for (int m = 0; m < sourceImg.height() - neg; m += neg) {
				for (int l = 0; l < neg; l++) {

					red = sourceImg.get(k + l, m + l).getRed()+1;
					blue = sourceImg.get(k + l, m + l).getBlue()+1;
					green = sourceImg.get(k + l, m + l).getGreen()+1;

					if (50 < red && red / blue > 1 && red / green > 1) {
						redpixel += 1;

					}

					if (blue > 50 && blue / red > 1) {
						bluepixel += 1;
					}

					if (50 < green && green / red > 0.9) {
						greenpixel += 1;

					}

				}

				//System.out.println(redpixel);

				// System.out.println(redpixel);
				System.out.println(greenpixel);

			}
			if (redpixel > thresholdred) {
				redball++;
				redpixel=0;
			}
			if (bluepixel > thresholdred) {
				blueball++;
				bluepixel=0;
			}
			if (greenpixel > thresholdgreen) {
				greenball++;
				greenpixel=0;
			}
		}
		countball[0] = redball;
		countball[1] = greenball;
		countball[2] = blueball;
		return countball;

	}

	public static Picture showBlueBall(Picture sourceImg) {
		int red = 0;
		int blue = 0;
		int green = 0;
		int bluepixel = 0;
		int countball = 0;
		int neg = 100;
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				red = sourceImg.get(i, j).getRed() + 1;
				blue = sourceImg.get(i, j).getBlue() + 1;
				green = sourceImg.get(i, j).getGreen() + 1;
				if (blue / red > 1) {
					newPicture.set(i, j, new Color(0, 0, blue));
				} else {
					newPicture.set(i, j, new Color(255, 255, 255));
				}
			}

		}

		for (int k = 0; k < sourceImg.width() - neg; k += neg) {
			for (int m = 0; m < sourceImg.height() - neg; m += neg) {
				for (int l = 0; l < neg; l++) {
					if (0 < sourceImg.get(k + l, m + l).getBlue() && sourceImg.get(k + l, m + l).getRed() < 100
							&& sourceImg.get(k + l, m + l).getGreen() < 100) {
						bluepixel++;

					}

				}
				System.out.println(bluepixel);
				if (bluepixel >= 10) {
					countball++;
				}
				bluepixel = 0;
			}

		}
		System.out.println(countball);
		return newPicture;
	}

	public static Picture showGreenBall(Picture sourceImg) {
		int red = 0;
		int blue = 0;
		int green = 0;
		int greenpixel = 0;
		int countball = 0;
		int neg = 100;
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				red = sourceImg.get(i, j).getRed();
				blue = sourceImg.get(i, j).getBlue();
				green = sourceImg.get(i, j).getGreen();
				if (50 < green && green / red > 1.5) {
					newPicture.set(i, j, new Color(0, green, 0));
				}

				else {
					newPicture.set(i, j, new Color(255, 255, 255));
				}
			}

		}
		for (int k = 0; k < sourceImg.width() - neg; k += neg) {
			for (int m = 0; m < sourceImg.height() - neg; m += neg) {
				for (int l = 0; l < neg; l++) {
					if (75 < sourceImg.get(k + l, m + l).getGreen() && sourceImg.get(k + l, m + l).getBlue() < 100
							&& sourceImg.get(k + l, m + l).getRed() < 100) {
						greenpixel++;

					}

				}
				System.out.println(greenpixel);
				if (greenpixel >= 12) {
					countball++;
				}
				greenpixel = 0;
			}
		}
		System.out.println(countball);
		return newPicture;
	}
	

	 */

	public static Picture showGreen(Picture sourceImg) {
		int green = 0;
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				green = sourceImg.get(i, j).getGreen();
				newPicture.set(i, j, new Color(0, green, 0));
			}

		}
		return newPicture;
	}

	public static Picture showBlue(Picture sourceImg) {
		int blue = 0;
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				blue = sourceImg.get(i, j).getBlue();
				newPicture.set(i, j, new Color(0, 0, blue));
			}

		}
		return newPicture;
	}

	public static Picture mirrorX(Picture sourceImg) {

		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());

		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				newPicture.set(i, sourceImg.height() - j - 1, sourceImg.get(i, j));
			}
		}
		return newPicture;
	}

	public static Picture mirrorY(Picture sourceImg) {

		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());

		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				newPicture.set(sourceImg.width() - i - 1, j, sourceImg.get(i, j));
			}
		}
		return newPicture;
	}

	public static Picture visualEffectX(Picture sourceImg) {
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height() / 2; j++) {
				newPicture.set(i, j, sourceImg.get(i, j));
			}
			for (int j = sourceImg.height() / 2; j < sourceImg.height(); j++) {
				newPicture.set(i, j, sourceImg.get(i, sourceImg.height() - j - 1));
			}

		}

		return newPicture;

	}

	public static Picture visualEffectY(Picture sourceImg) {
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int j = 0; j < sourceImg.height(); j++) {
			for (int i = 0; i < sourceImg.width() / 2; i++) {
				newPicture.set(i, j, sourceImg.get(i, j));
			}
			for (int i = sourceImg.width() / 2; i < sourceImg.width(); i++) {
				newPicture.set(i, j, sourceImg.get(sourceImg.width() - i - 1, j));
			}

		}

		return newPicture;

	}

	public static Picture rotatehelp(Picture sourceImg) {
		Picture newPicture = new Picture(sourceImg.height(), sourceImg.width());
		for (int i = 0; i < sourceImg.width(); i++) {
			for (int j = 0; j < sourceImg.height(); j++) {
				newPicture.set(j, newPicture.height() - i - 1, sourceImg.get(i, j));
			}
		}

		return newPicture;
	}

	public static Picture rotate(Picture sourceImg, int theta) {

		if (theta == 90) {
			return rotatehelp(sourceImg);

		} else if (theta == 180) {
			return rotatehelp(rotatehelp(sourceImg));

		}

		else if (theta == 270) {
			return rotatehelp(rotatehelp(rotatehelp(sourceImg)));

		} else
			System.out.println("Not a valid rotational angle");
		return sourceImg;

	}

	public static Picture cropImage(Picture sourceImg, int x1, int x2, int y1, int y2) {
		if (x2 >= x1 && y2 >= y1 && 1 < x2 && x2 < sourceImg.width() && 1 < y2 && y2 < sourceImg.height()) {
			Picture newPicture = new Picture(x2 - x1, y2 - y1);
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					newPicture.set(i - x1, j - y1, sourceImg.get(i, j));
				}

			}
			return newPicture;
		} else {
			System.out.println("Invalid Parameters");
			return sourceImg;
		}
	}

	public static void findCircle(Picture sourceImg) {

	}

	public static Picture makeBrighter(Picture sourceImg, int k) {
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < newPicture.width(); i++) {
			for (int j = 0; j < newPicture.height(); j++) {
				if (sourceImg.get(i, j).getRed() + k > 255 || sourceImg.get(i, j).getBlue() + k > 255
						|| sourceImg.get(i, j).getGreen() + k > 255) {
					System.out.println("Max RGB Reached!");
					return sourceImg;
				} else {
					newPicture.set(i, j, new Color((sourceImg.get(i, j).getRed() + k),
							(sourceImg.get(i, j).getGreen() + k), (sourceImg.get(i, j).getBlue() + k)));
				}
			}
		}
		return newPicture;
	}
	public static Picture makeDarker(Picture sourceImg, int k) {
		Picture newPicture = new Picture(sourceImg.width(), sourceImg.height());
		for (int i = 0; i < newPicture.width(); i++) {
			for (int j = 0; j < newPicture.height(); j++) {
				if (sourceImg.get(i, j).getRed() - k >= 0 || sourceImg.get(i, j).getBlue()-k >=0
						|| sourceImg.get(i, j).getGreen() -k>=0) {
					System.out.println("Max RGB Reached!");
					return sourceImg;
				} else {
					newPicture.set(i, j, new Color((sourceImg.get(i, j).getRed() + k),
							(sourceImg.get(i, j).getGreen() + k), (sourceImg.get(i, j).getBlue() + k)));
				}
			}
		}
		return newPicture;
	}
}
