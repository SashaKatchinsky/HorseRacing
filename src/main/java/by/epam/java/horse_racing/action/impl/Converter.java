package by.epam.java.horse_racing.action.impl;

public interface Converter<What , ToWhat> {

    ToWhat convert(What object);
}
