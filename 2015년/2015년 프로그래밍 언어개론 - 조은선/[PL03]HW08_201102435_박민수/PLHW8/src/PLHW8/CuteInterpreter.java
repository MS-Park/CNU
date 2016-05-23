package PLHW8;

public class CuteInterpreter {
	private final static BooleanNode TRUE_NODE = new BooleanNode();
	private final static BooleanNode FALSE_NODE = new BooleanNode();
	static {
		TRUE_NODE.value = true;
		FALSE_NODE.value = false;
	}

	private void errorLog(String err) {
		System.out.println(err);
	}

	enum CopyMode {
		NO_NEXT, NEXT
	}

	private Node runFunction(FunctionNode func) {
		Node rhs1 = func.getNext();
		Node rhs2 = (rhs1 != null) ? rhs1.getNext() : null;
		switch (func.value) {
		case CAR: {
			if (!checkQuote(rhs1))
				errorLog("Syntax Error!");
			Node item = runQuote((ListNode) rhs1); // quote value ��
			// copyNode�� �̿��Ͽ� ���� return �Ͻÿ�.
			Node result = copyNode(((ListNode) item).value, CopyMode.NO_NEXT);
			return result;
		}
		case CDR: {
			if (!checkQuote(rhs1))
				errorLog("Syntax Error!");
			Node item = runQuote((ListNode) rhs1);
			// copyNode�� �̿��Ͽ� ���� return �Ͻÿ�.
			ListNode result = new ListNode();
			result.value = copyNode(((ListNode) item).value.next, CopyMode.NEXT);
			return result;
		}
		case CONS: {
			Node head = runExpr(rhs1); // ����
			Node tail = runExpr(rhs2); // List
			// CONS�� �°� �ۼ��Ұ�
			ListNode result = new ListNode();
			result.value = head;
			result.value.next = ((ListNode) tail).value;
			return result;
		}
		case ATOM_Q:
			if (!(rhs1 instanceof ListNode)
					|| (((ListNode) rhs1).value == null))
				return TRUE_NODE;
			else
				return FALSE_NODE;
		case EQ_Q:
			if (rhs1 != null && rhs1.equals(rhs2)) {
				return TRUE_NODE;
			} else {
				return FALSE_NODE;
			}
		case NULL_Q:
			if (rhs1 instanceof ListNode && ((ListNode) rhs1).value == null)
				return TRUE_NODE;

			else
				return FALSE_NODE;
		case NOT:
			if(((BooleanNode) rhs1).value == false){
				return TRUE_NODE;
			}
			else{
				return FALSE_NODE;
			}
		case COND:
			Node tmp2 = rhs1;
	         Node tmp1 = ((ListNode)rhs1).value;
	         while(tmp2 != null){
	            tmp1 = ((ListNode)tmp2).value;
	            if(tmp1 instanceof ListNode)
	            {
	               Node runResult = this.runList((ListNode)tmp1);
	               if(runResult instanceof BooleanNode && ((BooleanNode) runResult).value == true)
	               {
	                  return tmp1.getNext();
	               }
	            }
	            else
	            {
	               if(tmp1 instanceof BooleanNode && ((BooleanNode) tmp1).value == true)
	               {
	                  return tmp1.getNext();
	               }
	            }
	            tmp2 = tmp2.getNext();      
	         }
		default:
			break;
		}
		return null;
	}

	private Node copyNode(Node node, CopyMode mode) { // node�� ����
		// mode�� ���� next�� ������
		if (node == null)
			return null;
		Node result = null;
		if (node instanceof BinarayOpNode)
			result = new BinarayOpNode();
		else if (node instanceof BooleanNode)
			result = new BooleanNode();
		else if (node instanceof FunctionNode)
			result = new FunctionNode();
		else if (node instanceof IdNode)
			result = new IdNode();
		else if (node instanceof IntNode)
			result = new IntNode();
		else if (node instanceof ListNode)
			result = new ListNode();
		result.copyValue(node);
		if (mode == CopyMode.NEXT && result != null)
			result.setNext(copyNode(node.getNext(), mode));
		return result;
	}

	private Node runList(ListNode list) {
		// list�� value�� QuoteNode�� ���
		if (list.value instanceof QuoteNode)
			return runQuote(list);
		Node opCode = list.value;
		if (opCode == null)
			return list;
		if (opCode instanceof FunctionNode)
			return runFunction((FunctionNode) opCode);
		if(opCode instanceof BinarayOpNode)
			return runBinary((BinarayOpNode)opCode);
		return list;
	}

	private Node runQuote(ListNode node) {
		// QuoteNode�� value�� ��ȯ��
		QuoteNode qItem = (QuoteNode) node.value;
		Node item = qItem.value;
		return item;
	}

	public Node runExpr(Node rootExpr) {
		if (rootExpr == null)
			return null;
		if (rootExpr instanceof IdNode)
			return rootExpr;
		else if (rootExpr instanceof IntNode)
			return rootExpr;
		else if (rootExpr instanceof BooleanNode)
			return rootExpr;
		else if (rootExpr instanceof ListNode)
			return runList((ListNode) rootExpr);
		else
			errorLog("run Expr error");

		return null;
	}

	private boolean checkQuote(Node node) {
		// QuoteNode�� �������� Ȯ���ϴ� �޼ҵ�
		if (!(node instanceof ListNode))
			return false;
		ListNode tmp = (ListNode) node;
		if (!(tmp.value instanceof QuoteNode))
			return false;
		return true;
	}

	private Node runBinary(BinarayOpNode node) {
		Node result;
		Node left = node.getNext();
		Node right = left.getNext();
		left = runExpr(left);
		right = runExpr(right);
		if (left == null || right == null)
			errorLog("runBinary runExpr null");
		if (!(left instanceof IntNode) || !(right instanceof IntNode)) {
			errorLog("Type Error!");
			return null;
		}

		switch (node.value) {
		case MINUS:
			result = new IntNode();
			((IntNode) result).value = ((IntNode) left).value
					- ((IntNode) right).value;
			return result;
		case PLUS:	//+
			result = new IntNode();
			((IntNode) result).value = ((IntNode) left).value
					+ ((IntNode) right).value;
			return result;
		case TIMES:	//*
			result = new IntNode();
			((IntNode) result).value = ((IntNode) left).value
					* ((IntNode) right).value;
			return result;
		case DIV:	//'/
			result = new IntNode();
			((IntNode) result).value = ((IntNode) left).value
					/ ((IntNode) right).value;
			return result;
		case LT:	//<
			result = new BooleanNode();
			if(((IntNode) left).value < ((IntNode) right).value){
				((BooleanNode) result).value = true;
			}
			else{
				((BooleanNode) result).value = false;
			}
			return result;
		case GT:	//>
			result = new BooleanNode();
			if(((IntNode) left).value > ((IntNode) right).value){
				((BooleanNode) result).value = true;
			}
			else{
				((BooleanNode) result).value = false;
			}
			return result;
		case EQ:	//=
			result = new BooleanNode();
			if(((IntNode) left).value == ((IntNode) right).value){
				((BooleanNode) result).value = true;
			}
			else{
				((BooleanNode) result).value = false;
			}
			return result;
			
			// ��Ÿ ������, MINUS�� ����ϰ� ���� ������ �� PLUS, TIMES, DIV, LT, GT, EQ
			// ���迬���� TRUE, FALSE��ȯ
		}
		return null;
	}
}