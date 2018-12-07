package operator.etc;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class ReduceExample {
	
	
	public void basic()
	{
		/**
		 * data1 ù��° ������ data2 ���� ������ +=���� �����͸� �ռ��Ҷ� ���
		 */
		String[] balls = {"1","3","5","6"};
		Maybe<String> maybe = Observable.fromArray(balls).reduce((data1,data2)->{
			return  data1 + data2;
		});
		maybe.subscribe(System.out::println);
		
	}
	
	public void biFunction()
	{
		
		String[] balls = {"1","3","5","6"};
		
		BiFunction<String, String, String> biFunction = (input1 ,input2) -> {
			return input1 + input2;
		};

		Maybe<String> maybe2 = Observable.fromArray(balls).reduce(biFunction);
		
		maybe2.subscribe(System.out::println);
	}

	
	public static void main(String[] args) {

		ReduceExample example = new ReduceExample();
		example.basic();
		example.biFunction();
	}
}
