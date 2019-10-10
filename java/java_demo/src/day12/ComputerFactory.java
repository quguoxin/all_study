package day12;

import day12.cpu.CpuFactory;
import day12.harddisk.HardDiskFactory;
import day12.ram.EmsFactory;

public class ComputerFactory {
    public static void main(String[] args) {
        //CpuIntferace cpuIntferace, HardDiskIntferace hardDiskIntferace, Ems ems
      Computer computer=new Computer(new CpuFactory(),new HardDiskFactory(),new EmsFactory());
      computer.showComputer();
    }
}
