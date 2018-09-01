package biz.no1s.kenshu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/* 問1 */
public class Scraping {
	public static void main(String[] args){
		try{
			//「key=」の後にAPI_keyを入れてください
			String urlname = "https://sheets.googleapis.com/v4/spreadsheets/"
					+ "11BCnspCt2Mut3nhc4WMY6CYTd0zF9C3eCzsk1AEpKLM/values/"
					+ "A1:E6?key=";
			URL url = new URL(urlname);
			Object content = url.getContent();
			if(content instanceof InputStream){
				BufferedReader bf = new BufferedReader(new InputStreamReader((InputStream)content));
				String line;
				ArrayList<String> array = new ArrayList<String>();
				while((line = bf.readLine()) != null){
					array.add(line);
				}
				for(int j = 0;j < (array.size()-6)/7;j++){
					for(int i = 0;i < 4;i++){
						System.out.print(array.get(i+7*j+5).replace("\"","\'").replace(" ", ""));
					}
					System.out.println("");
				}
			}
		}catch(IOException e){
			System.out.println(e);
			System.exit(-1);
		}
	}
}
