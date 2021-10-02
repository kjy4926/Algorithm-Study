def solution(param0) :
    answer = ''
    result = []
    byte = ''

    for p in param0 :
        l = len(byte)
        if l > 128 :
            return 'HALT'
        if p == 'BOOL' :
            byte += '#'
        if p == 'SHORT' :
            if l % 2 == 0 :
                byte += '##'
            else :
                byte += '.'
                byte += '##'
        if p == 'FLOAT' :
            c = l % 4
            if c == 0 :
                byte += '####'
            else :
                byte += ('.' * c)
                byte += '####'
        if p == 'INT' :
            c = l % 8
            if c == 0 :
                byte += '########'
            else :
                byte += ('.' * c)
                byte += '########'
        if p == 'LONG' :
            c = l % 8
            if c == 0 :
                byte += '########'
                byte += '########'
            else :
                byte += ('.' * c)
                byte += '########'
                byte += '########'
    
    _str = ''
    for b in byte :
        _str += b
        if len(_str) == 8 :
            result.append(_str) 
            _str = ''
    result.append(_str)

    return ','.join(result)

param0 = ['SHORT', 'SHORT', 'BOOL', 'SHORT', 'INT', 'LONG', 'FLOAT', 'LONG']
print(solution(param0))