// This interface (IProgram) is used for creating better console interaction with
// separated laboratory works. One can run this project and select any program for
// the specified laboratory work.

public interface IProgram {
    void execute() throws Exception;
    String getProgramName();
}