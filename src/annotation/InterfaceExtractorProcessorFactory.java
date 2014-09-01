/**
 * 
 */
package annotation;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

/**第20章 20.3使用apt处理注解
 * 搞不懂这个使用apt处理注解到底是怎么运行的
 * @author Administrator
 *
 */
public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory {

	/* (non-Javadoc)
	 * @see com.sun.mirror.apt.AnnotationProcessorFactory#getProcessorFor(java.util.Set, com.sun.mirror.apt.AnnotationProcessorEnvironment)
	 */
	@Override
	public AnnotationProcessor getProcessorFor(
			Set<AnnotationTypeDeclaration> arg0,
			AnnotationProcessorEnvironment arg1) {
		return new InterfaceExtractorProcessor(arg1);
	}

	/* (non-Javadoc)
	 * @see com.sun.mirror.apt.AnnotationProcessorFactory#supportedAnnotationTypes()
	 */
	@Override
	public Collection<String> supportedAnnotationTypes() {
		return Collections.singleton("annotation.ExtractInterface");
	}

	/* (non-Javadoc)
	 * @see com.sun.mirror.apt.AnnotationProcessorFactory#supportedOptions()
	 */
	@Override
	public Collection<String> supportedOptions() {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}

}
