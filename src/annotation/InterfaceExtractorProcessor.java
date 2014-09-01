/**
 * 
 */
package annotation;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

/**第20章 20.3使用apt处理注解
 * 搞不懂这个使用apt处理注解到底是怎么运行的
 * @author Administrator
 *
 */
public class InterfaceExtractorProcessor implements AnnotationProcessor {

	private final AnnotationProcessorEnvironment env;
	
	private List<MethodDeclaration> interfaceMethods = new ArrayList<MethodDeclaration>();
	
	public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env){
		this.env = env;
	}
	
	/* (non-Javadoc)
	 * @see com.sun.mirror.apt.AnnotationProcessor#process()
	 */
	@Override
	public void process() {
		for(TypeDeclaration declaration:env.getSpecifiedTypeDeclarations()){
			ExtractInterface annotation = declaration.getAnnotation(ExtractInterface.class);
			if(annotation==null){
				break;
			}
			for(MethodDeclaration m:declaration.getMethods()){
				if(m.getModifiers().contains(Modifier.PUBLIC)&&!(m.getModifiers().contains(Modifier.STATIC)))
					interfaceMethods.add(m);
			}
			if(interfaceMethods.size()>0){
				try {
					PrintWriter writer = env.getFiler().createSourceFile(annotation.value());
					writer.println("package "+declaration.getPackage().getQualifiedName()+";");
					writer.println("public interface "+annotation.value()+" {");
					for(MethodDeclaration m:interfaceMethods){
						writer.print(" public ");
						writer.print(m.getReturnType()+" ");
						writer.print(m.getSimpleName()+ "(");
						int i=0;
						for(ParameterDeclaration parm:m.getParameters()){
							writer.print(parm.getType()+" "+parm.getSimpleName());
							if(++i<m.getParameters().size()){
								writer.print(", ");
							}
						}
						writer.println(");");
					}
					writer.print("}");
					writer.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
	}

	
	
	
}
