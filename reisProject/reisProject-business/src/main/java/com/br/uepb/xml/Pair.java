package com.br.uepb.xml;

public class Pair <T, U>  {	
	private T first;
	private U second;
	private transient final int hash;

	public Pair( T f, U s )
	{
		this.first = f;
		this.second = s;
		hash = (first == null? 0 : first.hashCode() * 31)
				+(second == null? 0 : second.hashCode());
	}

	public T getFirst()
	{
		return first;
	}
	
	public void setFirst(T _first) {
		first = _first;
	}
	
	public void setSecond(U _second) {
		second = _second;
	}
	
	
	public U getSecond()
	{
		return second;
	}
	
	@Override
	public int hashCode()
	{
		return hash;
	}
	
	@Override
	public boolean equals( Object oth )
	{
		if ( this == oth )
		{
			return true;
		}
		if ( oth == null || !(getClass().isInstance( oth )) )
		{
			return false;
		}
		Pair<T, U> other = getClass().cast( oth );
			return (first == null? other.first == null : first.equals( other.first ))
			 && (second == null? other.second == null : second.equals( other.second ));
	}
}
