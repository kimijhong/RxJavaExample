package operator.transform;

import comm.CommUtil;
import comm.Log;
import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class GroupByExample {
	
	public void emit()
	{
		String objs[] = {"6","4","2-T","2","6-T","4-T"};
		
		Observable<GroupedObservable<String, String>> observable = Observable.fromArray(objs).groupBy(CommUtil::getShape);
		
		observable.subscribe(result -> {
			
			result.subscribe(val->{
				
				System.out.println(result.getKey() + " " + val);
			});
			
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupByExample example = new GroupByExample();
		example.emit();
	}
}
