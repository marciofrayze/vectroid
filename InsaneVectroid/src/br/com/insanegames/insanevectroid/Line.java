package br.com.insanegames.insanevectroid;

public class Line {
	
	public Position startPosition;
	public Position endPosition;
	
	public Line(float x, float y, float x2, float y2) {
		startPosition = new Position(x, y);
		endPosition = new Position(x2, y2);
	}

}
