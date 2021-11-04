package ru.job4j.ood.lsp.violations;

public class DerivedExecutor extends BaseExecutor {

    @Override
    public void executeB() {
        throw new UnsupportedOperationException();
    }
}
