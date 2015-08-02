package com.nullcognition.workedarchitecture.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent{

	public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

	static{
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
		addItem(new DummyItem(String.valueOf(DummyItem.idCounter)));
	}

	private static void addItem(DummyItem item){
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	public static class DummyItem{
		public String id;
		public String content;
		public static long idCounter = 0;

		public DummyItem(String content){
			this.id = String.valueOf(idCounter++);
			this.content = content;
		}

		@Override
		public String toString(){
			return content;
		}
	}
}
