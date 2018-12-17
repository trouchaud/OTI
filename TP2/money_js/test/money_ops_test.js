QUnit.module("moneyOps", {
//	setup:function(assert){alert("setup moneyOps individual test");},
//	teardown:function(assert){alert("teardown moneyOps individual test");}
});

QUnit.test("test simple add", function(assert)
{
	assert.expect(2);

	var m1=new money(1,"EUR");
  var m2=new money(2,"EUR");
  var m3=new money(3,"EUR");

	assert.ok(m3.equals(MoneyOps.add(m1,m2)),"3e = 1e+2e");
	assert.deepEqual(m3,MoneyOps.add(m1,m2),"3e = 1e+2e deepEqual");
}
);


QUnit.test("test multi devises add", function(assert)
{
	var m1=new money(1,"EUR");
  var m2=new money(4,"CHF");
	assert.throws(function(assert) {var m3=MoneyOps.add(m1,m2)}, DevisesIncompatibleExc, "Devises Incompatibles");
}
);

QUnit.test("test simple Sub", function(assert)
{
	assert.expect(2);
	var m1=new money(5,"EUR");
	var m2=new money(4,"EUR");
	var m3=new money(1,"EUR");
	assert.ok(m3.equals(MoneyOps.sub(m1,m2)), "1e = 5e-4e");
	assert.deepEqual(m3, MoneyOps.sub(m1,m2), "1e = 5e-4e deepEqual");
});


QUnit.test("Sub inferieur a 0", function(assert)
{
    assert.expect(1);
    var m1=new money(7,"EUR");
    var m2=new money(8,"EUR");
    assert.throws(function(assert) { var m3= MoneyOps.sub(m1,m2)}, OperationSubImpossible, "Valeur négative");
});

QUnit.test("Sub devise differente", function(assert)
{
	assert.expect(1);
	var m1=new money(8,"EUR");
	var m2=new money(8,"CHF");
	assert.throws(function(assert) { var m3= MoneyOps.sub(m1,m2)}, DevisesIncompatibleExc, "Devises Incompatible");
});

QUnit.test("Devise supp a trois", function(assert)
{
	assert.expect(1);
	var m1=new money(8,"EURS");
	var m2=new money(7,"EURS");
	assert.throws(function(assert){ var m3= MoneyOps.sub(m1,m2)}, DeviseSuppATrois, "Devise incorrect, supp à trois");
})
