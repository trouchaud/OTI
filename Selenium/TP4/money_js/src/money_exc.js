function DevisesIncompatibleExc(_d1,_d2) {
	this.d1=_d1; this.d2=_d2;

}

DevisesIncompatibleExc.prototype.toString=function (){
		return "Devises incompatibles : "+this.d1+" vs "+this.d2;
}

function OperationSubImpossible(_d1,_d2) {
	this.d1=_d1; this.d2=_d2;

}

OperationSubImpossible.prototype.toString=function (){
		return "Operation soustraction impossible : "+this.d1+"-"+this.d2;
}
