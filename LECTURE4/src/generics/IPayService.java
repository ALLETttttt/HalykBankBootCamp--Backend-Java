package generics;

public interface IPayService<Arg, Ret> {

    Ret invoke(Arg arg);
}
