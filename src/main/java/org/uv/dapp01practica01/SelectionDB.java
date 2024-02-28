package org.uv.dapp01practica01;

import java.sql.Connection;
import java.util.List;

public abstract class SelectionDB <T, ID> {
    public abstract List<T> find(Connection con);
}
