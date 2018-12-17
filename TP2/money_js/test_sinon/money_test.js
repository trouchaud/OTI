QUnit.module("money", {
//	setup:function(assert){alert("setup money individual QUnit.test");},
//	teardown:function(assert){alert("teardown money individual QUnit.test");}
});

QUnit.test("test construct money",function(assert)
{
	var m=new money(1,"EUR");
	assert.ok(m.v==1,"valeur = 1");
	assert.equal(m.curr,"EUR","currency = EUR");
}
);

QUnit.test("test accesseurs", function(assert)
{
	assert.expect(2);
	var m=new money(1,"EUR");
	assert.ok(m.getValue()==1,"valeur = 1");
	assert.equal(m.getCurrency(),"EUR","currency = EUR");
}
);


QUnit.test("test equals", function(assert)
{
	assert.expect(4);

	var m1eur=new money(1,"EUR");
	sinon.stub(m1eur,"getValue").returns(1);
	sinon.stub(m1eur,"getCurrency").returns("EUR");

	var m1EUR=sinon.stub(new money(1,"EUR"));
	m1EUR.getValue.returns(1);
	m1EUR.getCurrency.returns("EUR");

    var m1CHF=sinon.stub(new money());
    m1EUR.getValue.returns(1);
    m1EUR.getCurrency.returns("CHF");

    var m10eur=sinon.createStubInstance(money)
    m1EUR.getValue.returns(10);
    m1EUR.getCurrency.returns("EUR");

	var m1EUR=new money(1,"EUR");
	var m1eur=new money(1,"eur");
	var m1CHF=new money(1,"CHF");
	var m10eur=new money(10,"eur");

	assert.ok(m1EUR.equals(m1EUR),"1 EUR égal à 1 EUR");
	assert.ok(m1EUR.equals(m1eur),"1 EUR égal à 1 eur");
	assert.ok(!m1EUR.equals(m1CHF),"1 EUR diff de 1 CHF");
	assert.ok(!m1EUR.equals(m10eur),"1 EUR diff de 10 eur");
}
);

QUnit.test("test equals sans avec sans stub", function(assert)
{
	assert.expect(3);

    var m1eur=new money(1,"EUR");
    sinon.stub(m1eur,"getValue").returns(1);
    sinon.stub(m1eur,"getCurrency").returns("EUR");

    var m1EUR=sinon.stub(new money(1,"EUR"));
    m1EUR.getValue.returns(1);
    m1EUR.getCurrency.returns("EUR");
    m1EUR.equals.restore();

    assert.ok(m1eur.equals(m1EUR), "1 eur égale à 1 EUR");
    assert.ok(m1EUR.equals(m1eur), "1 EUR égale à 1 eur");
    assert.deepEqual(m1eur,m1EUR);


});

Qunit.test("spy getValue / getCurrency", function(assert)
{
	assert.expect(4);

	var m1eur=new money(1,"eur");
	var m1EUR=new money(1,"EUR");

	m1eur_gv=sinon.spy(m1eur,"getValue");
	m1eur_gc=sinon.spy(m1eur,"getCurrency");
	m1EUR_gv=sinon.spy(m1EUR,"getValue");
	m1EUR_gc=sinon.spy(m1EUR,"getCurrency");

	m1eur.equals(m1EUR);

	assert.ok(m1eur_gv.calledOnce);
	assert.ok(m1eur_gc.calledOnce);

	assert.ok(m1EUR_gv.calledOnce);
	assert.ok(m1EUR_gc.calledOnce);
});
