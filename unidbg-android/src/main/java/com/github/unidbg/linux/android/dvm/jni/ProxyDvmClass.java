package com.github.unidbg.linux.android.dvm.jni;

import com.github.unidbg.linux.android.dvm.BaseVM;
import com.github.unidbg.linux.android.dvm.DvmClass;

class ProxyDvmClass extends DvmClass {

    ProxyDvmClass(BaseVM vm, String className, DvmClass[] interfaceClasses, ClassLoader classLoader) {
        super(vm, className, interfaceClasses, null);

        setJni(new ProxyJni(classLoader));

        try {
            this.value = classLoader.loadClass(getName());
        } catch (ClassNotFoundException ignored) {
        }
    }

}
