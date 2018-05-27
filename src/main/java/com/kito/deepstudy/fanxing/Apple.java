package com.kito.deepstudy.fanxing;

/**
 * 2016年7月12日
 * @author zhaoyi
 * TODO
 */
public class Apple<T,S,A> extends Fruit<T,S> {
	A _num;
	public Apple(T _name,S _value,A _num){
		super(_name,_value);
		this._num=_num;
	}
	/* (non-Javadoc)
	 * @see com.kito.deepstudy.fanxing.Fruit#sayItSelf()
	 */
	@Override
	public void sayItSelf() {
		// TODO Auto-generated method stub
		super.sayItSelf();
		System.out.println(_num);
	}
}
