package com.zyd.util;


 import java.util.Arrays;
 import java.util.Collection;
 import java.util.Collections;
 import java.util.Enumeration;
 import java.util.Iterator;
 import java.util.LinkedHashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Map.Entry;
 import java.util.Properties;
 
 
 public abstract class CollectionUtils
 {
   public CollectionUtils() {}
   
   public static boolean isEmpty(Collection<?> collection)
   {
     return (collection == null) || (collection.isEmpty());
   }
   
 
 
   public static boolean isEmpty(Map<?, ?> map)
   {
     return (map == null) || (map.isEmpty());
   }
   
 
 
 
   public static List arrayToList(Object source)
   {
     return Arrays.asList(ObjectUtils.toObjectArray(source));
   }
   
 
 
 
 
   public static boolean contains(Iterator<?> iterator, Object element)
   {
     if (iterator != null) {
       while (iterator.hasNext()) {
         Object candidate = iterator.next();
         if (ObjectUtils.nullSafeEquals(candidate, element)) {
           return true;
         }
       }
     }
     return false;
   }
   
 
 
   public static boolean contains(Enumeration<?> enumeration, Object element)
   {
     if (enumeration != null) {
       while (enumeration.hasMoreElements()) {
         Object candidate = enumeration.nextElement();
         if (ObjectUtils.nullSafeEquals(candidate, element)) {
           return true;
         }
       }
     }
     return false;
   }
   
 
 
   public static boolean containsInstance(Collection<?> collection, Object element)
   {
     if (collection != null) {
       for (Object candidate : collection) {
         if (candidate == element) {
           return true;
         }
       }
     }
     return false;
   }
   
 
 
   public static boolean containsAny(Collection<?> source, Collection<?> candidates)
   {
     if ((isEmpty(source)) || (isEmpty(candidates))) {
       return false;
     }
     for (Object candidate : candidates) {
       if (source.contains(candidate)) {
         return true;
       }
     }
     return false;
   }
   
 
 
 
   
 
 
   public static <E> Iterator<E> toIterator(Enumeration<E> enumeration)
   {
     return new EnumerationIterator(enumeration);
   }
   
 
 
 
 
   private static class EnumerationIterator<E>
     implements Iterator<E>
   {
     private Enumeration<E> enumeration;
     
 
     public EnumerationIterator(Enumeration<E> enumeration)
     {
       this.enumeration = enumeration;
     }
     
     public boolean hasNext()
     {
       return this.enumeration.hasMoreElements();
     }
     
     public E next()
     {
       return this.enumeration.nextElement();
     }
     
     public void remove() throws UnsupportedOperationException
     {
       throw new UnsupportedOperationException("Not supported");
     }
   }
   
 
 
   public static <T> T getFirst(Collection<T> collection)
   {
     if (isEmpty(collection)) {
       return null;
     }
     
     return collection.iterator().next();
   }
   
 
 
   public static boolean isNotEmpty(Collection<?> collection)
   {
     return (collection != null) && (!collection.isEmpty());
   }
 }

