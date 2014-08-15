/**
 * 
 */
package io.xml;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

/**
 * @author Administrator
 * 
 */
public class Person {

	private String first;
	private String last;

	public Person(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public Element getXml() {
		Element person = new Element("person");
		Element firstName = new Element("first");
		firstName.appendChild(first);
		Element lastName = new Element("last");
		lastName.appendChild(last);
		person.appendChild(firstName);
		person.appendChild(lastName);
		return person;
	}

	public Person(Element person) {
		first = person.getFirstChildElement("person").getValue();
		last = person.getFirstChildElement("last").getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return first + " " + last;
	}

	public static void format(OutputStream out, Document doc)
			throws IOException {
		Serializer serializer = new Serializer(out, "UTF-8");
		serializer.setIndent(4);
		serializer.setMaxLength(60);
		serializer.write(doc);
		serializer.flush();

	}

	public static void main(String[] args) throws Exception{
		List<Person> people = Arrays.asList(
				new Person("Dr.Bosen", "Honey Droew"),
				new Person("Mr. Zhang", "Xiao hua"),
				new Person("Coder Ptee", "Hurr我的"));
		System.out.println(people);
		
		Element root = new Element("people");
		for(Person person:people){
			root.appendChild(person.getXml());
		}
		Document document = new Document(root);
		format(System.out, document);
		format(new BufferedOutputStream(new FileOutputStream("people.xml")), document);
		

	}

}
