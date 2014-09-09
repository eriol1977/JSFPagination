/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francesco
 */
public class CC
{

    public static final String FIND_ALL = "CC.findAll";

    public static final String FIND_WITH_SALDO_HIGHER_THAN = "CC.findWithSaldoHigherThan";

    private Integer id;

    private Integer saldo;

    public CC()
    {

    }

    public CC(Integer id, Integer saldo)
    {
        this.id = id;
        this.saldo = saldo;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getSaldo()
    {
        return saldo;
    }

    public void setSaldo(Integer saldo)
    {
        this.saldo = saldo;
    }

    @Override
    public String toString()
    {
        return "CC " + this.id + ": saldo " + this.saldo;
    }

}
