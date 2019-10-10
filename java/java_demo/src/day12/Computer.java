package day12;

import day12.cpu.CpuIntferace;
import day12.harddisk.HardDiskIntferace;
import day12.ram.Ems;



public class Computer {
    private CpuIntferace cpuIntferace;
    private HardDiskIntferace hardDiskIntferace;
    private Ems ems;

    public CpuIntferace getCpuIntferace() {
        return cpuIntferace;
    }

    public void setCpuIntferace(CpuIntferace cpuIntferace) {
        this.cpuIntferace = cpuIntferace;
    }

    public HardDiskIntferace getHardDiskIntferace() {
        return hardDiskIntferace;
    }

    public void setHardDiskIntferace(HardDiskIntferace hardDiskIntferace) {
        this.hardDiskIntferace = hardDiskIntferace;
    }

    public Ems getEms() {
        return ems;
    }

    public void setEms(Ems ems) {
        this.ems = ems;
    }

    public Computer() {
    }

    public Computer(CpuIntferace cpuIntferace, HardDiskIntferace hardDiskIntferace, Ems ems) {
        this.cpuIntferace = cpuIntferace;
        this.hardDiskIntferace = hardDiskIntferace;
        this.ems = ems;
    }

    public void showComputer(){
        System.out.println("计算机的信息如下：\n"+cpuIntferace.cpuMassage()+"\n"+ems.getRam()+"\n"+hardDiskIntferace.getCapacity());
    }
}
