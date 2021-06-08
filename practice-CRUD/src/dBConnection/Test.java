package dBConnection;

import java.util.List;

import model.Newspaper;
import newspaperDAO.NewspaperDAO;

public class Test {
	
	public static void main(String[] args) {		
		NewspaperDAO instance = NewspaperDAO.getInstance();
		
		Newspaper newspaper = new Newspaper("pqMinh", "Phạm Quang Minh");
		System.out.println(instance.insertNewspaper(newspaper));
		
		Newspaper newspaper1 = new Newspaper(8, "pqTu", "Phạm Quang Tu");
		System.out.println(instance.updateNewspaper(newspaper1));
		System.out.println(instance.deleteNewspaper(12));
		
		List<Newspaper> list = instance.selectAllNewspapers();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
