/**
 * 
 */
package annotation.dataBase;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**注解处理器
 * 读取一个类文件，检查其上的数据库注解，并生成创建数据库的SQL语句
 * @author Administrator
 *
 */
public class TableCreator {

	public static void main(String[] args) throws Exception {
		if(args.length<1){
			System.out.println("arguments: annotated classes");
			System.exit(0);
		}
		for(String className:args){
			Class<?> cl = Class.forName(className);
			DBtable dBtable = cl.getAnnotation(DBtable.class);
			if(dBtable == null){
				System.out.println("no DBtable annotations in class"+className);
				continue;
			}
			String tableName = dBtable.name();
			if(tableName.length()<1){	//没有表名，取默认的类名
				tableName = cl.getName().toUpperCase();
			}
			List<String> columnDefs = new ArrayList<String>();
			for(Field field:cl.getDeclaredFields()){
				String columnName = null;
				Annotation[] annotations = field.getDeclaredAnnotations();
				if(annotations.length<1)
					continue;
				if(annotations[0] instanceof SQLInteger){
					SQLInteger sInteger = (SQLInteger) annotations[0];
					if(sInteger.name().length()<1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sInteger.name();
					columnDefs.add(columnName+" INT" + getConstraints(sInteger.constraints()));
				}
				if(annotations[0] instanceof SQLString){
					SQLString sString = (SQLString) annotations[0];
					if(sString.name().length()<1)
						columnName = field.getName().toUpperCase();
					else
						columnName = sString.name();
					columnDefs.add(columnName+" VARCHAR("+sString.value()+")" + getConstraints(sString.constraints()));
				}
				StringBuilder createCommand = new StringBuilder("create table "+tableName+"(");
				for(String columnDef:columnDefs)
					createCommand.append("\n"+columnDef+",");
				String tableCreate = createCommand.substring(0,createCommand.length()-1)+");";
				System.out.println("Table create SQL for "+className+" is:\n"+tableCreate);
			}
			
		}
		
		
	}

	/**
	 * @param constraints
	 * @return
	 */
	private static String getConstraints(Constraints constraints) {
		String cons = " ";
		if(!constraints.allowNull())
			cons += "NOT NULL";
		if(constraints.primarkKey())
			cons += "PRIMARY KEY";
		if(constraints.unique())
			cons += "UNIQUE";
		return cons;
	}
	
	
	
	
	
	
	
	
}
