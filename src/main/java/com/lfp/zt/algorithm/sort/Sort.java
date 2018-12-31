package com.lfp.zt.algorithm.sort;

import java.util.*;

/**
 * Project: zt-javabase
 * Title:
 * Description:
 * Date: 2018-12-31
 * Copyright: Copyright (c) 2018
 * Company: qudian
 *
 * @author ZhuTao
 * @version 2.0
 */
public interface Sort<T> extends Comparator<T> {

    default Collection<T> sort(Collection<T> origin){
        T[] tmpOrigin = (T[]) origin.toArray();
        T[] result = this.sort(tmpOrigin);
        if (origin instanceof List){
            return Arrays.asList(result);
        }else if (origin instanceof Set){
            return new TreeSet(Arrays.asList(result));
        }
        return Arrays.asList(result);
    }

    T[] sort(T[] origin);

    default int compare(T o1, T o2) {
        if (o1 instanceof Comparable){
            return ((Comparable) o1).compareTo(o2);
        }
        return o1.toString().compareTo(o2.toString());
    }

    default void swap(T[] origin, int i, int j){
        T tmp = origin[i];
        origin[i] = origin[j];
        origin[j] = tmp;
    }

}
