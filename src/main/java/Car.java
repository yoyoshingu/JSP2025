

public class Car {
	
	public abstract class CC{
	
		final public void left() {
		}
		abstract public void right(); 
		public void middle() {
			
		}
	}
	
	
	public class Bike extends CC{

		@Override
		public void right() {
				
		}
		
//		@Override
//		public void left() {
//				
//		}

		
	}
	
	Bike mini = new Bike();

	
	
}


