package com.pengyifan.nlp.brat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Range;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.HasOffset;

/**
 * CoreAnnotations.IDAnnotation: id <br />
 * CoreAnnotations.EntityTypeAnnotation: type <br />
 * 
 */
public class BratEntity extends BratAnnotation implements HasOffset {

  /**
   * 
   */
  private static final long    serialVersionUID = -7731569470434643148L;
  /**
   * discontinuous spans: start-offset, end-offset
   */
  private List<Range<Integer>> spans;

  public BratEntity() {
    spans = new ArrayList<Range<Integer>>();
  }

  public BratEntity(BratEntity ent) {
    this();
    setId(ent.getId());
    setType(ent.getType());
    setText(ent.getText());
    for (int i = 0; i < ent.numberOfSpans(); i++) {
      addSpan(ent.span(i));
    }
  }

  /**
   * 
   * @return the text spanned by the annotation
   */
  public String getText() {
    return get(CoreAnnotations.TextAnnotation.class);
  }

  public void setText(String text) {
    set(CoreAnnotations.TextAnnotation.class, text);
  }

  /**
   * 
   * @param span start-offset, end-offset
   */
  public void addSpan(Range<Integer> span) {
    addSpan(span.getMinimum(), span.getMaximum());
  }

  /**
   * 
   * @param start the index of the first character of the annotated span in the
   *          text
   * @param end the index of the first character after the annotated span
   */
  public void addSpan(int start, int end) {
    spans.add(Range.between(start, end));
    if (!has(CoreAnnotations.CharacterOffsetBeginAnnotation.class)) {
      setBeginPosition(start);
      setEndPosition(end);
    } else {
      // update start and end
      if (beginPosition() > start) {
        setBeginPosition(start);
      }
      if (endPosition() < end) {
        setEndPosition(end);
      }
    }
  }

  public int start(int i) {
    return span(i).getMinimum();
  }

  public int end(int i) {
    return span(i).getMaximum();
  }

  public Range<Integer> span(int i) {
    return spans.get(i);
  }

  public int numberOfSpans() {
    return spans.size();
  }

  public Range<Integer> totalSpan() {
    return Range.between(beginPosition(), endPosition());
  }

  @Override
  public int beginPosition() {
    return get(CoreAnnotations.CharacterOffsetBeginAnnotation.class);
  }

  @Override
  public int endPosition() {
    return get(CoreAnnotations.CharacterOffsetEndAnnotation.class);
  }

  @Override
  public void setBeginPosition(int start) {
    set(CoreAnnotations.CharacterOffsetBeginAnnotation.class, start);
  }

  @Override
  public void setEndPosition(int end) {
    set(CoreAnnotations.CharacterOffsetEndAnnotation.class, end);
  }
}