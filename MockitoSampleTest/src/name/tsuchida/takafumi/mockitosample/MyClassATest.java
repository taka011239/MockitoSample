package name.tsuchida.takafumi.mockitosample;

import android.test.InstrumentationTestCase;
import static org.mockito.Mockito.*;

public class MyClassATest extends InstrumentationTestCase  {

	protected void setUp() throws Exception {
		super.setUp();
		System.setProperty(
		        "dexmaker.dexcache",
		        getInstrumentation().getTargetContext().getCacheDir().getPath());
	}

	public void testWhenHighPriority() {
		MyClassB mockClassB = mock(MyClassB.class);
		when(mockClassB.getPriority()).thenReturn(100);
		
		MyClassA mockClassA = spy(new MyClassA(mockClassB));
		
		mockClassA.hoge();
		
		verify(mockClassA, times(1)).handleHighPriority();
		verify(mockClassA, never()).handleLowPriority();
	}
	
	public void testWhenLowPriority() {
		MyClassB mockClassB = mock(MyClassB.class);
		when(mockClassB.getPriority()).thenReturn(0);
		
		MyClassA mockClassA = spy(new MyClassA(mockClassB));
		
		mockClassA.hoge();
		
		verify(mockClassA, times(1)).handleLowPriority();
		verify(mockClassA, never()).handleHighPriority();
	}
}
