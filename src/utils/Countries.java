package utils;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Administrator
 *
 */
public class Countries {

//世界各国及首府中英文对照
	public static final String[][] DATA = {
//		大洋州 	Oceania
		{"American Samoa","Pago Pago "},{"Australia","Canberra"},
		{"French Polynesia","Papeete"},{"Fiji","Suva"},
		{"Guam","Hagatna (Agana)"},{"Micronesia","Palikir"},
		{"Nauru","government offices in Yaren District"},{"N. Mariana Islands","Saipan"},
		{"New Caledonia","Noumea"},{"New Zealand","Wellington"},
		{"Papua New Guinea","Port Moresby"},{"Pitcairn Island","Adamstown"},
		{"Western Samoa","Apia"},
		
//		亚洲			Asia 
		{"Bangladesh","Dhaka"},{"Laos","Vientiane"},
		{"Afghanistan","Kabul"},{"Bhutan","Thimphu"},
		{"Burma","Rangoon"},{"Cambodia","Phnom Penh "},
		{"China","Beijing/Hong Kong/Taiwan/Macau"},{"India","New Delhi"},
		{"Indonesia","Jakarta"},{"Japan","Tokyo"},
		{"Malaysia","Kuala Lumpur"},{"Maldives","Male"},
		{"Mongolia","Ulaanbaatar"},{"Nepal","Kathmandu"},
		{"North Korea","P'yongyang"},{"Pakistan","Islamabad"},
		{"Philippines","Manila"},{"Singapore","Singapore"},
		{"South Korea","Seoul"},{"Sri Lanka","Colombo"},
		{"Thailand","Bangkok"},{"Turkey","Ankara"},
		{"Vietnam","Hanoi"},{"Brunei","Bandar Seri Begawan"},
		{"Palestine",null},{"Sikkim","Gangtok"},
	
// III. 美洲 	(America) 
		{"Anguilla","The Valley"},{"Antigua and Barbuda","Saint John's"},
		{"Argentina","Buenos Aires"},{"The Bahamas","Nassau"},
		{"Barbados","Bridgetown"},{"Belize","Belmopan"},
		{"Bermuda","Hamilton"},{"Bolivia","La Paz"},
		{"Brazil","Brasilia"},{"British Virgin Islands","Road Town"},
		{"Canada","Ottawa"},{"Chile","Santiago"},
		{"Colombia","Bogota"},{"Costa Rica","San Jose"},
		{"Cuba","Havana"},{"Dominican Republic","Santo Domingo"},
		{"Ecuador","Quito"},{"El Salvador","San Salvador"},
		{"Greenland","Nuuk (Godthab)"},{"Grenada","Saint George's "},
		{"Guadeloupe","Basse-Terre"},{"Guatemala","Guatemala"},
		{"Guyana","Georgetown"},{"Haiti","Port-au-Prince "},
		{"Honduras","Tegucigalpa"},{"Jamaica","Kingston"},
		{"Martinique","Fort-de-France "},{"Mexico","Mexico"},
		{"Montserrat","Plymouth"},{"Nicaragua","Managua"},
		{"Panama","Panama"},{"Paraguay","Asuncion"},
		{"Peru","Lima"},{"Puerto Rico","San Juan"},
		{"St. Lucia","Castries"},{"St. Vincent and the Grenadines","Kingstown"},
		{"Suriname","Paramaribo"},{"Trinidad and Tobago","Port-of-Spain"},
		{"Turks and Caicos Islands","Grand Turk"},{"United States","Washington, DC"},
		{"Uruguay","Montevideo"},{"Venezuela","Caracas"},
		{"Virgin Islands","Charlotte Amalie"},{"",""},
		
		
//		IV. 欧洲 	(Europe)
		{"Albania","Tirana"},{"Austria","Vienna"},
		{"Belgium","Brussels"},{"Bulgaria","Sofia"},
		{"Croatia","Zagreb"},{"Cyprus","Nicosia"},
		{"Denmark","Copenhagen"},{"Finland","Helsinki"},
		{"France","Paris"},{"Germany","Berlin"},
		{"Greece","Athens"},{"Hungary","Budapest"},
		{"Iceland","Reykjavik"},{"Ireland","Dublin"},
		{"Italy","Rome"},{"Liechtenstein","Vaduz"},
		{"Luxembourg","Luxembourg"},{"Macedonia","Skopje"},
		{"Malta","Valletta"},{"Monaco","Monaco"},
		{"Netherlands","Amsterdam"},{"Norway","Oslo"},
		{"Poland","Warsaw"},{"Portugal","Lisbon"},
		{"Romania","Bucharest"},{"Russia","Moscow"},
		{"San Marino","San Marino"},{"Slovenia","Ljubljana"},
		{"Spain","Madrid"},{"Sweden","Stockholm"},
		{"Switzerland","Bern"},{"United Kingdom","London"},
		{"Yugoslavia","Belgrade"},{"",""},
		
//		V. 非洲     (Africa) 
		{"Algeria","Algiers"},{"Angola","Luanda"},
		{"Benin","Porto-Novo"},{"Botswana","Gaborone"},
		{"Burundi","Bujumbura"},{"Cameroon","Yaounde"},
		{"Central African Republic","Bangui"},{"Chad","N'Djamena"},
		{"Congo Rep.","Brazzaville"},{"Djibouti","Djibouti"},
		{"Egypt","Cairo"},{"Equatorial Guinea","Malabo"},
		{"Eritrea","Asmara"},{"Ethiopia","Addis Ababa"},
		{"Gabon","Libreville"},{"The Gambia","Banjul"},
		{"Ghana","Accra"},{"Guinea","Conakry"},
		{"Guinea-Bissau","Bissau"},{"Kenya","Nairobi"},
		{"Lesotho","Maseru"},{"Liberia","Monrovia"},
		{"Libya","Tripoli"},{"Madagascar","Antananarivo"},
		{"Malawi","Lilongwe"},{"Mali","Bamako"},
		{"Mauritius","Port Louis"},{"Mauritania","Nouakchott"},
		{"Morocco","Rabat"},{"Mozambique","Maputo"},
		{"Namibia","Windhoek"},{"Niger","Niamey"},
		{"Nigeria","Abuja"},{"Reunion","Saint-Denis"},
		{"Republic of the Congo","Kinshasa"},{"Rwanda","Kigali"},
		{"Sao Tome and Principe","Sao Tome"},{"Senegal","Dakar"},
		{"Seychelles","Victoria"},{"Sierra Leone","Freetown"},
		{"Somalia","Mogadishu"},{"South Africa","Pretoria"},
		{"Sudan","Khartoum"},{"Swaziland","Mbabane"},
		{"Tanzania","Dar es Salaam"},{"Togo","Lome"},
		{"Tunisia","Tunis"},{"Uganda","Kampala"},
		{"Western Sahara",null},{"Zambia","Lusaka"},
		{"Zimbabwe","Harare"}
	};
	
	private static class FlyWeightMap extends AbstractMap<String, String>{

		private static class Entry implements Map.Entry<String, String>{

			int index;
			Entry(int index) {
				this.index = index;
			}
			public boolean equals(Object o){
				return DATA[index][0].equals(o);
			}
			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return DATA[index][0];
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return DATA[index][1];
			}

			@Override
			public String setValue(String value) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
			
			@Override
			public int hashCode() {
				// TODO Auto-generated method stub
				return DATA[index][0].hashCode();
			}
			
		}
		//Use AbstractSet by implementing size() and iterator()
		static class EntrySet extends AbstractSet<Map.Entry<String, String>>{

			private int size;
			public EntrySet(int size) {
				if(size<0)
					this.size = 0;
				else if(size>DATA.length)
					this.size = DATA.length;
				else 
					this.size = size;
			}
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return this.size;
			}
			private class Iter implements Iterator<Map.Entry<String, String>>{
				//only one Entry object per Iterator
				private Entry entry = new Entry(-1);
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return entry.index<size-1;
				}
				@Override
				public java.util.Map.Entry<String, String> next() {
					// TODO Auto-generated method stub
					entry.index++;
					return entry;
				}
				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			}
			@Override
			public Iterator<java.util.Map.Entry<String, String>> iterator() {
				// TODO Auto-generated method stub
				return new Iter();
			}
			
		}
		
		private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);
		
		@Override
		public Set<java.util.Map.Entry<String, String>> entrySet() {
			// TODO Auto-generated method stub
			return entries;
		}
	}
	
	//create a partial Map of 'size' countries
	static Map<String, String> select(final int size){
		return new FlyWeightMap(){
			public Set<Map.Entry<String, String>> entrySet(){
				return new EntrySet(size);
			}
		};
	}
	
	static Map<String, String> map = new FlyWeightMap();
	public static Map<String, String> captials(){
		return map;
	}
	public static Map<String, String> captials(int size){
		return select(size);
	}
	
	static List<String> names = new ArrayList<String>(map.keySet());
	//all the names
	public static List<String> names(){
		return names;
	}
	
	public static List<String> names(int size){
		return new ArrayList<String>(select(size).keySet());
	}
	
	public static void main(String[] args) {
		System.out.println(captials(10));
		System.out.println(names(10));
		System.out.println(new HashMap<String, String>(captials(3)));
		System.out.println(new LinkedHashMap<String, String>(captials(3)));
		System.out.println(new TreeMap<String, String>(captials(3)));
		System.out.println(new Hashtable<String,String>(captials(3)));	///why????
		System.out.println(new HashSet<String>(names(6)));
		System.out.println(new LinkedHashSet<String>(names(6)));
		System.out.println(new TreeSet<String>(names(6)));
		System.out.println(new ArrayList<String>(names(6)));
		System.out.println(new LinkedList<String>(names(6)));
		System.out.println(captials().get("Brazil"));
		
		
	}
	
	
	
}
